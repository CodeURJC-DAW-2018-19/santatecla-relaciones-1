package es.santatecla.relaciones.user;


import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String userName;
	private String passwordHash;
	
	
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	
	public User() {}
	
/*	public User(String userName, String passwordHash, List<String> roles) {
		super();
		this.userName= userName;
		this.passwordHash = passwordHash;
		this.roles = roles;
			
	}*/
	
	public User(String userName, String password, List<String> roles) {
		super();
		this.userName = userName;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.roles = roles;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	
	

}
