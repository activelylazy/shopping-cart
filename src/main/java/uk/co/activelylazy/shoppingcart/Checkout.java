package uk.co.activelylazy.shoppingcart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Checkout {
	
	private static final Product Apple = new Product("Apple", new BigDecimal("0.60"));
	private static final Product Orange = new Product("Orange", new BigDecimal("0.25"));
	
	public BigDecimal scan(List<String> items) {
		Map<String, Long> counts = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		BigDecimal total = BigDecimal.ZERO;
		for (Map.Entry<String, Long> entry : counts.entrySet()) {
			String item = entry.getKey();
			Long count = entry.getValue();
			total = total.add(toItemPrice(item, count));
		}
		
		return total;
	}

	private BigDecimal toItemPrice(String item, Long count) {
		if (Apple.getName().equals(item)) {
			return Apple.getPrice(count);
		}
		if (Orange.getName().equals(item)) {
			return Orange.getPrice(count);
		}
		return BigDecimal.ZERO;
	}
}
