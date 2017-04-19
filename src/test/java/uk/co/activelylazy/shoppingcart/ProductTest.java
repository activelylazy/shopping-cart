package uk.co.activelylazy.shoppingcart;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;


public class ProductTest {

	@Test
	public void priceForMultipleItems() {
		Product product = new Product("Name", new BigDecimal("0.60"));
		
		assertThat(product.getPrice(2L), equalTo(new BigDecimal("1.20")));
	}
}
