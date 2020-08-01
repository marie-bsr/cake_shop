package fr.marie.ecommerce.service;

import java.util.List;

import fr.marie.ecommerce.model.Product;



public interface ProductService {
	
	public List<Product> getAllProducts();
	public Product getProductById(Long id);
	public Product save(Product product);
}
