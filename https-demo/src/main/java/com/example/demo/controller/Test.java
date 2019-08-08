package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Test {

	@GetMapping
	public Map<String, String> get() {
		Map<String, String> mp = new HashMap<>();
		mp.put("hello", "Hello World");

		return mp;
	}
}
