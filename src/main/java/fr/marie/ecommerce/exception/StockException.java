package fr.marie.ecommerce.exception;

public class StockException extends Exception {

	private static final long serialVersionUID = 6619488332089482505L;

	public StockException() {
		super("Stock error");
	}

	public StockException(String message) {
		super(message);
	}
}
