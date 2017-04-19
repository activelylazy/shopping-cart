package uk.co.activelylazy.shoppingcart;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

public class CheckoutTest {

	@Test
	public void scansItems() {
		List<String> items = asList("Apple", "Orange", "Orange");
		
		Checkout checkout = new Checkout();
		BigDecimal price = checkout.scan(items);
		
		assertThat(price, equalTo(new BigDecimal("1.10")));
	}
	
	@Test
	public void emptyListHasPriceZero() {
		Checkout checkout = new Checkout();
		
		assertThat(checkout.scan(asList()), equalTo(BigDecimal.ZERO));
	}
}
