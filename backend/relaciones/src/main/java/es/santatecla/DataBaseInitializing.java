package es.santatecla;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.santatecla.user.User;
import es.santatecla.user.UserRepository;



@Component
public class DataBaseInitializing {
	
	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {
		userRepository.save(new User("Miguel","1234", "ROLE_ADMIN","ROLE_USER"));
		userRepository.save(new User("Carlos","pass", "ROLE_USER"));
		
	}
		
		
		
	}


