package fr.marie.ecommerce.service;

import java.util.List;

import fr.marie.ecommerce.exception.StockException;
import fr.marie.ecommerce.model.Order;




public interface OrderService {
	public List<Order> getAllOrders();
	public Order create(Order order);
	public void update(Order order) throws StockException, fr.marie.ecommerce.exception.StockException;
}
