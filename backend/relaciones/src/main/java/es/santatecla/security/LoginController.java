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


@RestController
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserComponent userComponent;
	
	@RequestMapping("/api/login")
		public ResponseEntity<User> login() {
			
			if (!userComponent.isLoggedUser()) {
				log.info("Not user logged");
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			} else {
				User loggedUser = userComponent.getLoggedUser();
				log.info("Logged as " + loggedUser.getName());
				return new ResponseEntity<>(loggedUser, HttpStatus.OK);
			}
	}

	@RequestMapping("/api/loginerror")
	public String loginErrorController(Model model, HttpServletRequest request) {
		model.addAttribute("loginerror",true);
		return "/loginerror";//must see loginerror.html
	}
	
	@RequestMapping("/api/logout")
	public ResponseEntity<Boolean> logOut(HttpSession session) {

		if (!userComponent.isLoggedUser()) {
			log.info("No user logged");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			session.invalidate();
			log.info("Logged out");
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
	}

}
