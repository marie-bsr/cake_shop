package fr.marie.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import fr.marie.ecommerce.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	
}
