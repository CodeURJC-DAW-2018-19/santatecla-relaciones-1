package es.santatecla.user;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController extends UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserComponent userComponent;
	
	
	@PostConstruct
	public void init() {
		userRepository.save(new User("Miguel","1234", "ROLE_ADMIN"));
		userRepository.save(new User("Carlos","pass","ROLE_USER"));
		
	}
	
	@RequestMapping("/user")//Request to show the user's name 
	public String user(Model model) {
		Boolean b = userComponent.isLoggedUser();
		if (b) {
			User user = userComponent.getLoggedUser();
			user = userRepository.getById(user.getId());
			model.addAttribute(user.getName());
		}
			
		return "/alumn-unit";		
			
		}
	
	@RequestMapping("addUser")
	public String addUser(@RequestParam String name, @RequestParam String password) {
		if (userRepository.findByName(name) == null){
			User user = new User(name,password,"ROLE_USER");
			userRepository.save(user);
			userComponent.setLoggedUser(user);
			return "/alumn-unit";
		}
		else {
			return "error";//Custom error page
		}
	
	}
	
	
	
	
	
	

}
