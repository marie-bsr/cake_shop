package fr.marie.ecommerce.model;

public class OrderProduct {
	
	//attributs
	private Product product;
	private Integer quantity;

	//constructeurs
	public OrderProduct() {
		super();
	}
	
	public OrderProduct(Product product, Integer quantity) {
		
		this.product = product;
		this.quantity = quantity;
	}

//getters
	public Product getProduct() {
		return product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	
	//methodes
	public Double getTotalPrice() {
		return getProduct().getPrice() * getQuantity();
	}

	@Override
	public String toString() {
		return "OrderProduct [product_id=" + product.getId() + ", quantity=" + quantity
				+ "]";
	}

}
