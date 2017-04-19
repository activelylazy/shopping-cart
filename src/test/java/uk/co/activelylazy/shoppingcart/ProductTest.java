package uk.co.activelylazy.shoppingcart;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;


public class ProductTest {

	@Test
	public void priceForMultipleItems() {
		Product product = new Product("Name", new BigDecimal("0.60"), 1, 1);
		
		assertThat(product.getPrice(2L), equalTo(new BigDecimal("1.20")));
	}
	
	@Test
	public void buyOneGetOneFreePrice() {
		Product product = new Product("Name", new BigDecimal("0.60"), 1, 2);
		
		assertThat(product.getPrice(1L), equalTo(new BigDecimal("0.60")));
		assertThat(product.getPrice(2L), equalTo(new BigDecimal("0.60")));
		assertThat(product.getPrice(3L), equalTo(new BigDecimal("1.20")));
		assertThat(product.getPrice(4L), equalTo(new BigDecimal("1.20")));
	}
}
