package com.deltacapita.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.deltacapita.models.Cart;
import com.deltacapita.service.CartService;

@Service	
public class CartServiceImpl implements CartService {

	@Override
	public Long getDiscountedPrice(List<Cart> items, Map<String, Integer> map) {

		Long cost = 0l;
		int melon = 0, lime = 0;
		List<String> fruits = new ArrayList<>();
		for (Cart item : items) {
			for (int j = 0; j < item.getQuantity(); j++)
				fruits.add(item.getProductName());
		}

		for (String fruit : fruits) {
			if (fruit.equals("Melon")) {
				melon++;
				if (melon == 2) {
					melon = 0;
					continue;
				}
			} else if (fruit.equals("Lime")) {
				lime++;
				if (lime == 3) {
					lime = 0;
					continue;
				}
			}
			cost += map.get(fruit);
		}
		return cost;
	}
}
