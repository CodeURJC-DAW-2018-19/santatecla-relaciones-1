package es.santatecla.user;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity// This tells Hibernate to make a table out of this class
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String name;
	private String passwordHash;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;


	public User() {}
	
	

	public User(String name, String passwordHash, List<String> roles) {
		super();
		this.name = name;
		this.passwordHash = passwordHash;
		this.roles = roles;
	}



	public User(String name, String password, String... roles) {
		this.name = name;
		this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash);
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPassword(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	

	

}