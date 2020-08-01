package fr.marie.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
	
	//attributs
	@Id
	private Long id;
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	private Integer quantity;
	
	
	//constructeur
	
	public Stock(Long id, Product product, Integer quantity) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}

	//getters
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public Integer getQuantity() {
		return quantity;
	}


	
	//methodes
	public boolean isProductAvailable(int quantite) {
		//retourne si un produit est disponible selon une quantité passée en paramètre
		
		if (quantite >= quantity) {
			return true;
		} else {
			return false;
		}
		
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
	}

	

}
