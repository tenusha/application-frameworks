package com.sliit.af.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sliit.af.model.JWTAuthenticationToken;
import com.sliit.af.model.JWTUser;
import com.sliit.af.model.JWTUserDetils;

@Component
public class JWTAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JWTValidator validator;

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return JWTAuthenticationToken.class.isAssignableFrom(authentication);
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

		JWTAuthenticationToken jwtAuthenticationToken = (JWTAuthenticationToken) authentication;

		String token = jwtAuthenticationToken.getToken();

		JWTUser jwtUser = validator.validate(token);

		if (jwtUser == null) {
			throw new RuntimeException("JWT token is incorrect");
		}

		List<GrantedAuthority> grntedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(jwtUser.getRole());
		return new JWTUserDetils(jwtUser.getUsername(), jwtUser.getId(), token, grntedAuthorities);

	}

}
