package com.sliit.af.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sliit.af.security.JWTAuthenticationEntryPoint;
import com.sliit.af.security.JWTAuthenticationProvider;
import com.sliit.af.security.JWTAuthenticationTokenFilter;
import com.sliit.af.security.JWTSuccessHandler;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JWTAuthenticationProvider authenticationProvider;
	@Autowired
	private JWTAuthenticationEntryPoint entryPoint;

	@Bean
	public AuthenticationManager authenticationManager() {

		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}

	@Bean
	public JWTAuthenticationTokenFilter authenticationTokenFilter() {
		JWTAuthenticationTokenFilter filter = new JWTAuthenticationTokenFilter();
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationSuccessHandler(new JWTSuccessHandler());
		return filter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.csrf().disable().authorizeRequests().antMatchers("**/api/**").authenticated()
				.and()
				.exceptionHandling().authenticationEntryPoint(entryPoint)
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		
		http.headers().cacheControl();
	}

}
