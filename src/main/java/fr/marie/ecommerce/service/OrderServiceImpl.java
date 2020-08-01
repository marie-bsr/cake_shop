package fr.marie.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import fr.marie.ecommerce.exception.StockException;
import fr.marie.ecommerce.model.Order;
import fr.marie.ecommerce.model.OrderProduct;
import fr.marie.ecommerce.model.Product;

@Service("orders")
public class OrderServiceImpl implements OrderService {
	
	private List<Order> allOrders = new ArrayList<Order>();
	
	@Autowired
	private StockService stockService;
	
	//getters et setters

	public StockService getStockService() {
		return stockService;
	}

	@Override
	public String toString() {
		return "OrderServiceImpl [allOrders=" + allOrders + ", stockService=" + stockService + "]";
	}

	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}
	
	//methodes

	@Override
	public List<Order> getAllOrders() {
		
		return allOrders;
	}

	@Override
	public Order create(Order order) {
		// modifie la date de la commande à la date actuelle, et modifie le statut de la commande à “En cours”.
		order.setDateCreated(LocalDate.now());
		order.setStatus("En cours");
		allOrders.add(order);

		return order;
		
	}
	
	

	@Override
	public void update(Order order) throws StockException {
		// met à jours la commande et “l’enregistre” si le statut marqué “Payée”. 
		//Dans ce cas il faut mettre à jours les stocks pour les produits de cette
		//commande selon les quantités. Attention cette méthode peut lever une exception dans
		//le cas ou il n’y a pas assez de stock pour un produit.
		
		if (order.getStatus().equals("Payée")) {
			for (OrderProduct orderProduct : order.getOrderProducts()) {
				stockService.removeProduct(orderProduct.getProduct(), orderProduct.getQuantity());
			}
		}
		
	}

	

}


