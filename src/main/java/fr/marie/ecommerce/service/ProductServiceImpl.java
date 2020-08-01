package fr.marie.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.marie.ecommerce.exception.ResourceNotFoundException;
import fr.marie.ecommerce.model.Product;
import fr.marie.ecommerce.repository.ProductRepository;


@Service("products")
public class ProductServiceImpl implements ProductService {

	//plus utile avec la BDD
	//private final List<Product> allProducts = new ArrayList<>();

	/*public List<Product> getAllProducts() {
		return allProducts;
	}
	*/
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
	List<Product> products = new ArrayList<>();
	productRepository.findAll().forEach(products::add);
	return products;
	}
	@Override
	public Product getProductById(Long id) {
	return productRepository.findById(id).orElseThrow(() -> new
	ResourceNotFoundException("Product not found"));

	}
	@Override
	public Product save(Product product) {
	return productRepository.save(product);
	}
	}
	
/*
	public Product getProductById(Long id) {
		
		Product result = null;
		
		for (Product product: allProducts) {
           if(product.getId().equals(id)) {
        	   result = product;
        	   break;
           }}
		if (result == null) {
        	   throw new ResourceNotFoundException();
           }
		return result;
		}
	
    
	//solution Peter 
	public Product getProductById(Long id) {		
		return allProducts.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Product not found"));	
	}
	

	public Product save(Product product) {
		allProducts.add(product);
		return product;

	}

*/



