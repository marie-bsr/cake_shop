package fr.marie.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import fr.marie.ecommerce.service.ProductService;
import fr.marie.ecommerce.service.StockService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private StockService stockService;
	
	@GetMapping(value = { "", "/" })
	public String getProducts(Model model) {
		System.out.println("/products : get all products");
		model.addAttribute("products", productService.getAllProducts());

		return "products";
	}

	@GetMapping("/{productId}")
	public String getProductById(Model model, @PathVariable("productId") Long productId) {
		System.out.println("/products/id : get product by id (" + productId + ")");
		model.addAttribute("product", productService.getProductById(productId));
		
		System.out.println(stockService.getStockByProductId(productId));
		model.addAttribute("stock", stockService.getStockByProductId(productId));
		
		return "product";
	}
	
}