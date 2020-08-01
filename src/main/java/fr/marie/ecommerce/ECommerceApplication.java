package fr.marie.ecommerce;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.marie.ecommerce.exception.StockException;
import fr.marie.ecommerce.model.Order;
import fr.marie.ecommerce.model.Product;
import fr.marie.ecommerce.model.Stock;
import fr.marie.ecommerce.service.OrderService;
import fr.marie.ecommerce.service.ProductService;
import fr.marie.ecommerce.service.StockService;



//@SpringBootApplication
@ComponentScan("fr.*")
@SpringBootApplication


public class ECommerceApplication {
	
	// Main pour le TP1
		public static void mainTP1(String[] args) {

		
		Product pain = new Product(1L, "pain", "pain complet bio", 2.0, "url1");
		Product baguette = new Product(2L, "baguette", "baguette blé", 1.0, "url2");
		Product brioche = new Product(3L, "brioche", "grosse brioche", 4.0, "url3");
		
		Stock stock_pain = new Stock (1L,pain,50);
		Stock stock_baguette = new Stock (2L,baguette,70);
		Stock stock_brioche = new Stock (3L,brioche,30);
		
		Order dupont = new Order(1L,LocalDate.now(), "en cours");
		dupont.addProduct(pain, 2);
		dupont.addProduct(baguette, 2);

		dupont.setStatus("Payée");
		
		System.out.println(dupont.toString());
				
		
	}
	
	// Main pour le TP2
	public static void mainTP2(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
		ProductService productService = context.getBean("products", ProductService.class);
		StockService stockService = context.getBean("stocks", StockService.class);
		OrderService orderService = context.getBean("orders", OrderService.class);

		Product product1 = new Product(1l, "pain", "description du pain", 2d, "url1");
		Product product2 = new Product(2l, "baguette", "description de la baguette", 1d, "url2");
		Product product3 = new Product(3l, "brioche", "description de la brioche", 4d, "url3");

		productService.save(product1);
		productService.save(product2);
		productService.save(product3);

		// productService.getAllProducts().stream().forEach(System.out::println);

		stockService.addProduct(product1, 14);
		stockService.addProduct(product2, 12);
		stockService.addProduct(product3, 21);

		System.out.println("--------------- Stocks ---------------");
		stockService.getAllStock().stream().forEach(System.out::println);

		Order order = new Order();
		order.addProduct(product1, 2);
		order.addProduct(product3, 1);

		// On la créée
		orderService.create(order);

		// On la paye
		order.setStatus("Payée");
		System.out.println("---> price : " + order.getTotalOrderPrice());
		
		try {
			orderService.update(order);
		} catch (StockException e) {
			e.printStackTrace();
		}

		System.out.println("--------------- Stocks ---------------");
		stockService.getAllStock().stream().forEach(System.out::println);
	}

	//Main pour le TP3
	public static void mainTP3(String[] args) {
		//SpringApplication.run(ECommerceApplication.class, args);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ECommerceApplication.class);
		ProductService productService = context.getBean("products", ProductService.class);
		StockService stockService = context.getBean("stocks", StockService.class);
		OrderService orderService = context.getBean("orders", OrderService.class);
		
		Product product1 = new Product(1l, "pain", "description du pain", 2d, "url1");
		Product product2 = new Product(2l, "baguette", "description de la baguette", 1d, "url2");
		Product product3 = new Product(3l, "brioche", "description de la brioche", 4d, "url3");

		productService.save(product1);
		productService.save(product2);
		productService.save(product3);

		// productService.getAllProducts().stream().forEach(System.out::println);

		stockService.addProduct(product1, 14);
		stockService.addProduct(product2, 12);
		stockService.addProduct(product3, 21);

		System.out.println("--------------- Stocks ---------------");
		stockService.getAllStock().stream().forEach(System.out::println);

		Order order = new Order();
		order.addProduct(product1, 2);
		order.addProduct(product3, 1);

		// On la créée
		orderService.create(order);

		// On la paye
		order.setStatus("Payée");
		System.out.println("---> price : " + order.getTotalOrderPrice());
		
		try {
			orderService.update(order);
		} catch (StockException e) {
			e.printStackTrace();
		}

		System.out.println("--------------- Stocks ---------------");
		stockService.getAllStock().stream().forEach(System.out::println);
	}
	

	public static void main(String[] args) {
		
		SpringApplication.run(ECommerceApplication.class, args);
		
		
	}
	/*
	@Bean
	CommandLineRunner runner(ProductService productService, StockService stockService)
	{
	return args -> {
	Product product1 = new Product(1l, "Muffin Premium", "excellent gateau au chocolat", 4d, "https://images.unsplash.com/photo-1570922454036-13bb59d423de?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80");

	Product product2 = new Product(2l, "The best Donuts", "pour ceux qui aiment le sucre et le gras", 3d, "https://images.unsplash.com/photo-1509665653475-295f17f738e6?ixlib=rb-1.2.1&auto=format&fit=crop&w=1534&q=80");
	productService.save(product1);
	productService.save(product2);
	stockService.addProduct(product1, 2);
	stockService.addProduct(product2, 2);
	};
	}
	
	*/
		
	}


	
	


