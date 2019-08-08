package com.sliit.af.security;

import org.springframework.stereotype.Component;

import com.sliit.af.model.JWTUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTGenerator {

	public String generate(JWTUser jwtUser) {

		Claims claims = Jwts.claims().setSubject(jwtUser.getUsername());
		claims.put("userId", String.valueOf(jwtUser.getId()));
		claims.put("role", jwtUser.getRole());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "protected").compact();

	}

}
