package com.deltacapita.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.deltacapita.models.Cart;
import com.deltacapita.service.CartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	static Map<String, Integer> map = new HashMap<>();
	{
		map.put("Apple", 35);
		map.put("Banana", 20);
		map.put("Melon", 50);
		map.put("Lime", 15);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String thing(HttpSession session, Model model) {
		List<Cart> items = (List<Cart>) session.getAttribute("items");
		if (items == null) {
			items = new ArrayList<>(); // Initialize the list if not already in the session
			session.setAttribute("items", items);
		}

		Long discountedPrice = cartService.getDiscountedPrice(items, map);
		model.addAttribute("mapOfFruits", map);
		model.addAttribute("items", items);
		model.addAttribute("newCart", new Cart());
		model.addAttribute("afterDiscPrice", discountedPrice);
		return "cart";
	}

	@PostMapping("/add-items")
	public String addItem(@ModelAttribute("cart") Cart item, HttpSession httpSession) {
		List<Cart> items = (List<Cart>) httpSession.getAttribute("items");
		if (items == null) {
			items = new ArrayList<>();
		}
		items.add(item); // Add the new user to the session list
		httpSession.setAttribute("items", items); // Update the session attribute
		return "redirect:/deltacapita/";
	}
}