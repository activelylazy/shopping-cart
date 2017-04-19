package uk.co.activelylazy.shoppingcart;

import java.math.BigDecimal;

class Product {
	private final String name;
	private final BigDecimal price;
	
	public Product(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}	
	
}