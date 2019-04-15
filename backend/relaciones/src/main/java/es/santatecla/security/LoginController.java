package es.santatecla.security;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santatecla.user.User;
import es.santatecla.user.UserComponent;


//@RestController
//public class LoginController {
//
//	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
//
//	@Autowired
//	private UserComponent userComponent;
//
//	@RequestMapping("/api/logIn")
//	public ResponseEntity<User> logIn() {
//		
//		if (!userComponent.isLoggedUser()) {
//			log.info("Not user logged");
//			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//		} else {
//			User loggedUser = userComponent.getLoggedUser();
//			log.info("Logged as " + loggedUser.getName());
//			return new ResponseEntity<>(loggedUser, HttpStatus.OK);
//		}
//	}
//
//	@RequestMapping("/api/logOut")
//	public ResponseEntity<Boolean> logOut(HttpSession session) {
//
//		if (!userComponent.isLoggedUser()) {
//			log.info("No user logged");
//			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//		} else {
//			session.invalidate();
//			log.info("Logged out");
//			return new ResponseEntity<>(true, HttpStatus.OK);
//		}
//	}
//
//}
@Controller
public class LoginController {
	
	@Autowired
	UserComponent userComponent;
	
//	@RequestMapping("/")
//	public String home() {
//		return"/";
//	}
	
	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		model.addAttribute("loginerror",false);
		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		
		return"/";
	}

	@RequestMapping("/loginerror")
	public String loginErrorController(Model model, HttpServletRequest request) {
		model.addAttribute("loginerror",true);
		return "/loginerror";//must see loginerror.html
	}
	
//	@RequestMapping("/admin")
//	public String admin() {
//		return "teacher-units";
//	}
//	
//	@RequestMapping("/showUser")
//	public String show(Model model, HttpServletRequest request) {
//		model.addAttribute("logged",userComponent.isLoggedUser());
//			if (userComponent.isLoggedUser()){
//				model.addAttribute("name", userComponent.getLoggedUser().getName());
//			}
//		return "index";
//			}
}
