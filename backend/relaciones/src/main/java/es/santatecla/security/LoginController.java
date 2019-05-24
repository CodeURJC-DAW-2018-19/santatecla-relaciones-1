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


@Controller
public class LoginController {
	
	@Autowired
	UserComponent userComponent;
	
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
}
