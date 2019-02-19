package es.santatecla.relaciones.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/user")//Request to show the user's name 
	public String user(Model model) {
		Boolean b = userComponent.isLoggedUser();
		if (b) {
			User user = userComponent.getLoggedUser();
			user = uRepository.getById(user.getId());
			model.addAttribute(user.getName());
		}
			
		return "/alumn-unit";		
			
		}
	
	@RequestMapping("addUser")
	public String addUser(@RequestParam String name, @RequestParam String password) {
		if (uRepository.findByName(name) == null){
			User user = new User(name,password,"ROLE_USER");
			uRepository.save(user);
			userComponent.setLoggedUser(user);
			return "/alumn-unit";
		}
		else {
			return "error";//Custom error page
		}
	
	}
	
	
	
	
	
	

}
