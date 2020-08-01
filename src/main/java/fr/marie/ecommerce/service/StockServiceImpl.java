package fr.marie.ecommerce.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.marie.ecommerce.exception.ResourceNotFoundException;
import fr.marie.ecommerce.exception.StockException;
import fr.marie.ecommerce.model.Order;
import fr.marie.ecommerce.model.OrderProduct;
import fr.marie.ecommerce.model.Product;
import fr.marie.ecommerce.model.Stock;
import fr.marie.ecommerce.repository.ProductRepository;
import fr.marie.ecommerce.repository.StockRepository;

@Service("stocks")
public class StockServiceImpl implements StockService {

	/*
	 * private final List<Stock> allStock = new ArrayList<>();
	 * 
	 * @Override public List<Stock> getAllStock() {
	 * 
	 * return allStock; }
	 * 
	 * 
	 * @Autowired private StockRepository stockRepository;
	 * 
	 * 
	 * @Override public Stock getStockByProductId(Long productId) { Stock result =
	 * null;
	 * 
	 * for (Stock stock : allStock) { if (stock.getId().equals(productId)) { result
	 * = stock; break; } } if (result == null) { throw new
	 * ResourceNotFoundException(); } return result; }
	 * 
	 * 
	 * correction
	 * 
	 * @Override public Stock getStockByProductId(Long id) {
	 * 
	 * Optional<Stock> result = allStock.stream().filter(stock ->
	 * stock.getProduct().getId() == id).findAny();
	 * 
	 * if (result.isPresent()) { return result.get(); }
	 * 
	 * return null; }
	 * 
	 * 
	 * 
	 * @Override public boolean isProductAvailable(Product product, int quantity) {
	 * 
	 * Optional<Stock> result = allStock.stream().filter(stock ->
	 * stock.getProduct().equals(product)).findAny();
	 * 
	 * if (result.isPresent()) { return result.get().isProductAvailable(quantity); }
	 * 
	 * return false; }
	 * 
	 * @Override // si le produit (verif by id) est déjà en stock il faut seulement
	 * ajouter sa // quantite sinon tu l'ajoutes à la liste public void
	 * addProduct(Product product, int quantity) { if (isProductAvailable(product,
	 * 1)) { addProduct(product, quantity); } else { Stock stock = new Stock(null,
	 * product, quantity); allStock.add(stock);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * @Override public void removeProduct(Product product, int quantity) throws
	 * StockException {
	 * 
	 * Optional<Stock> result = allStock.stream().filter(stock ->
	 * stock.getProduct().equals(product)).findAny();
	 * 
	 * if (result.isPresent()) { if (result.get().isProductAvailable(quantity)) {
	 * result.get().setQuantity(result.get().getQuantity() - quantity); } else {
	 * throw new StockException(product + " not available in " + quantity +
	 * " item(s)"); }
	 * 
	 * }
	 * 
	 * }
	 */

	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<Stock> getAllStock() {

		List<Stock> stock = new ArrayList<>();
		stockRepository.findAll().forEach(stock::add);
		return stock;
	}

	@Override
	public boolean isProductAvailable(Product product, int quantity) {

		Optional<Stock> result = stockRepository.findByProductId(product.getId());

		if (result.isPresent()) {
			return result.get().isProductAvailable(quantity);
		} return false;
	}

	@Override
	public void addProduct(Product product, int quantity) {
		Optional<Stock> result = stockRepository.findByProductId(product.getId());
		if (result.isPresent()) {
			result.get().setQuantity(result.get().getQuantity() + quantity);
		} else {
			stockRepository.save(new Stock(0l, product, quantity));
			}
	}
@Override
	public void removeProduct(Product product, int quantity) throws StockException {
		Optional<Stock> result = stockRepository.findByProductId(product.getId());

		if (result.isPresent()) {
			if (result.get().isProductAvailable(quantity)) {
				result.get().setQuantity(result.get().getQuantity() - quantity);
			} else {
				throw new StockException(product + " not available in " + quantity);
				}

		}
}
@Override
	public Stock getStockByProductId(Long id){
		return stockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

}
