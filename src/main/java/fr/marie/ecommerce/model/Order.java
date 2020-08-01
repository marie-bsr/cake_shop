package fr.marie.ecommerce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

	//attributs
	private Long id;
	private LocalDate dateCreated;
	private String status;
	private List<OrderProduct> orderProducts = new ArrayList<>();

	
//constructeurs
	
	public Order() {
		super();
	}
	
	public Order(Long id, LocalDate dateCreated, String status) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.status = status;
	}
	
	//getters et setters

	public Long getId() {
		return id;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", dateCreated=" + dateCreated + ", status=" + status + ", orderProducts="
				+ orderProducts + "]";
	}

	public void addProduct(Product product, int quantity) {
		OrderProduct orderProduct = new OrderProduct(product, quantity);
		orderProducts.add(orderProduct);
	}

	public Double getTotalOrderPrice() {
		double sum = 0d;
		for (OrderProduct op : orderProducts) {
			sum += op.getTotalPrice();
		}
		return sum;
	}

	public int getNumberOfProducts() {
		return this.orderProducts.size();
	}

	public int getTotalNumberOfProducts() {
		int sum = 0;
		for (OrderProduct op : orderProducts) {
			sum += op.getQuantity();
		}
		return sum;
	}

}
