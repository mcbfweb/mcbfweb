package cl.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUser implements Serializable, UserDetails {

	private static final long serialVersionUID = 1201392234549297485L;
	private long id;
	private String password;
	private String username;
	private GrantedAuthority[] authorities = null;

	/**
	 * Instantiates a new custom user.
	 * 
	 * @param id
	 *            the id
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @param authorities
	 *            the authorities
	 */
	public CustomUser(int id, String username, String password, GrantedAuthority[] authorities) {
		this.id = id;
		this.password = password;
		this.username = username;
		this.authorities = authorities;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		for (int i = 0; i < authorities.length; i++) {
			auth.add(authorities[i]);
		}
		return auth;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	/**
	 * For convenience the below methods return all true; In a real application
	 * it is not desired, however.
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
