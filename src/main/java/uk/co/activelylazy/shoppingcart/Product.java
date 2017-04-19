package uk.co.activelylazy.shoppingcart;

import java.math.BigDecimal;

class Product {
	private final String name;
	private final BigDecimal price;
	private int payForItems;
	private int getItems;
	
	public Product(String name, BigDecimal price, int payForItems, int getItems) {
		super();
		this.name = name;
		this.price = price;
		this.payForItems = payForItems;
		this.getItems = getItems;
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public BigDecimal getPrice(Long count) {
		int offersTaken = count.intValue() / getItems;
		int remainder = count.intValue() % getItems;
		return price.multiply(new BigDecimal(offersTaken + remainder));
	}
	
}