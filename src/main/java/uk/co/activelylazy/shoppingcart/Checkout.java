package uk.co.activelylazy.shoppingcart;

import java.math.BigDecimal;
import java.util.List;

public class Checkout {
	
	private static final Product Apple = new Product("Apple", new BigDecimal("0.60"));
	private static final Product Orange = new Product("Orange", new BigDecimal("0.25"));
	
	public BigDecimal scan(List<String> items) {
		return items.stream()
				.map(this::toItemPrice)
				.reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
	}

	private BigDecimal toItemPrice(String item) {
		if (Apple.getName().equals(item)) {
			return Apple.getPrice();
		}
		if (Orange.getName().equals(item)) {
			return Orange.getPrice();
		}
		return BigDecimal.ZERO;
	}
}
