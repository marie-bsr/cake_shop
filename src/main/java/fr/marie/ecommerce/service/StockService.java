package fr.marie.ecommerce.service;

import java.util.List;

import fr.marie.ecommerce.exception.StockException;
import fr.marie.ecommerce.model.Product;
import fr.marie.ecommerce.model.Stock;



public interface StockService {
	
	public List<Stock> getAllStock();
	public Stock getStockByProductId(Long productId);
	public boolean isProductAvailable(Product product, int quantity);
	public void addProduct(Product product, int quantity);
	public void removeProduct(Product product, int quantity) throws StockException, fr.marie.ecommerce.exception.StockException;
}
