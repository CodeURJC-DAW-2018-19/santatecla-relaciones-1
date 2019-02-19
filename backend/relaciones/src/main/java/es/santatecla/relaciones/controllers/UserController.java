package es.santatecla.relaciones.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.santatecla.relaciones.service.UserService;
import es.santatecla.relaciones.user.User;
import es.santatecla.relaciones.user.UserComponent;
import es.santatecla.relaciones.user.UserRepository;

@Controller
public class UserController extends UserService {
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private UserComponent userComponent;
	
	
	@PostConstruct
	public void init() {
		uRepository.save(new User("Miguel","1234", "ROLE_ADMIN"));
		uRepository.save(new User("Carlos","pass","ROLE_USER"));
		
	}
	
	@RequestMapping("/user")//revisar
	public String user(Model model) {
		Boolean b = userComponent.isLoggedUser();
		if (b) {
			User user = userComponent.getLoggedUser();
			user = uRepository.getById(user.getId());}
			
		return "/alumn-unit";		
		
			
			
			
			
		}
	}
	
	
	
	
	
	

}
