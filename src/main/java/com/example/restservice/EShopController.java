package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.opentracing.Tracer;
import io.opentracing.Span;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EShopController {

	@Autowired
    private Tracer tracer;

	@GetMapping("/checkout")
	public String checkout(@RequestParam(value = "name", defaultValue = "World") String name) {
	
		Span span = tracer.buildSpan("checkout").start();
		// Add a wait to make it realistic
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		span.setTag("http.status_code",201);
		span.finish();
		return new String("You have successfully checked out your shopping cart");
	}
}
