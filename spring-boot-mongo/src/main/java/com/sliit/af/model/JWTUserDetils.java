package com.sliit.af.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class JWTUserDetils implements UserDetails {

	private String userName;
	private long id;
	private String token;
	private Collection<? extends GrantedAuthority> grntedAuthorities;

	public JWTUserDetils(String username, long id, String token, List<GrantedAuthority> grntedAuthorities) {
		super();
		this.userName = username;
		this.id = id;
		this.token = token;
		this.grntedAuthorities = grntedAuthorities;
	}

	public String getUserName() {
		return userName;
	}

	public long getId() {
		return id;
	}

	public String getToken() {
		return token;
	}

	public Collection<? extends GrantedAuthority> getGrntedAuthorities() {
		return grntedAuthorities;
	}

	public void setGrntedAuthorities(Collection<? extends GrantedAuthority> grntedAuthorities) {
		this.grntedAuthorities = grntedAuthorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grntedAuthorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public String getPassword() {
		return null;
	}

}
