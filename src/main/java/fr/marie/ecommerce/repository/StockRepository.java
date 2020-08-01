package fr.marie.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.marie.ecommerce.model.Product;
import fr.marie.ecommerce.model.Stock;

public interface StockRepository extends CrudRepository<Stock, Long> {
Optional<Stock> findByProductId(Long productId);
}


