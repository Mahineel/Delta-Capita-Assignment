package com.deltacapita.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.deltacapita.models.Cart;


public interface CartService {
	Long getDiscountedPrice(List<Cart> items, Map<String, Integer> map);

}
