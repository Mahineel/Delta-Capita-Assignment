package com.deltacapita.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.deltacapita.models.Cart;

class CartServiceImplTest {
	
	private Map<String, Integer> priceMap;

	@BeforeEach
	void setup() {
		priceMap = new HashMap<>();
		priceMap.put("Melon", 50);
		priceMap.put("Lime", 15);
	}

	@Test
	void testGetDiscountedPrice_EmptyCart() {
		// Arrange
		CartServiceImpl cartService = new CartServiceImpl();
		List<Cart> items = new ArrayList<>();

		// Act
		Long result = cartService.getDiscountedPrice(items, priceMap);

		// Assert
		assertEquals(0L, result);
	}

	@Test
	void testGetDiscountedPrice_SingleItem() {
		// Arrange
		CartServiceImpl cartService = new CartServiceImpl();
		Cart cartItem = Mockito.mock(Cart.class);
		when(cartItem.getProductName()).thenReturn("Melon");
		when(cartItem.getQuantity()).thenReturn(1);

		List<Cart> items = Arrays.asList(cartItem);
		Map<String, Integer> priceMap = new HashMap<>();
		priceMap.put("Melon", 50);

		// Act
		Long result = cartService.getDiscountedPrice(items, priceMap);

		// Assert
		assertEquals(50L, result);
	}

	@Test
	void testGetDiscountedPrice_DiscountsApplied() {
		// Arrange
		CartServiceImpl cartService = new CartServiceImpl();
		Cart cartItem1 = Mockito.mock(Cart.class);
		Cart cartItem2 = Mockito.mock(Cart.class);
		when(cartItem1.getProductName()).thenReturn("Melon");
		when(cartItem1.getQuantity()).thenReturn(2);
		when(cartItem2.getProductName()).thenReturn("Lime");
		when(cartItem2.getQuantity()).thenReturn(3);

		List<Cart> items = Arrays.asList(cartItem1, cartItem2);
		

		// Act
		Long result = cartService.getDiscountedPrice(items, priceMap);

		// Assert
		assertEquals(80L, result); // Only one melon and two limes should be counted
	}
}
