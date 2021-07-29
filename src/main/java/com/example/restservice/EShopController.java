package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EShopController {
    @GetMapping("/checkout")
	public String checkout(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new String("You have successfully checked out your shopping cart");
	}
}
