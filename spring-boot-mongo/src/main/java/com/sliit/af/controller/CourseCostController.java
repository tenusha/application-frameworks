package com.sliit.af.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sliit.af.model.JWTUser;
import com.sliit.af.security.JWTGenerator;
import com.sliit.af.services.CalcCostService;

@RestController
public class CourseCostController {

	@Autowired
	JWTGenerator jwtGenerator;
	
	@Autowired
	CalcCostService calcCostService;

	@RequestMapping("/api/courses/{cid}/cost")
	public double getCost(@PathVariable("cid") String cid) {
		return calcCostService.calcCost(cid);
	}

	@PostMapping("/login")
	public Object login(@RequestBody final JWTUser jwtUser) {

		System.out.println(jwtUser.toString());
		return jwtGenerator.generate(jwtUser);
	}

	@PostMapping("/register")
	public String register(@RequestBody Object body) {
		return "registered";
	}

	@GetMapping("/api/protected")
	@PreAuthorize("hasRole('ADMIN')")
	public String protectedData() {
		return "Protected Data";
	}
}
