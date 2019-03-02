package es.santatecla.user;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@Autowired
	UserComponent userComponent;
	
	@RequestMapping("/")
	public String home() {
		return"index";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {
		model.addAttribute("loginerror",false);
		return"/login";
	}

	@RequestMapping("/loginerror")
	public String loginErrorController(Model model, HttpServletRequest request) {
		model.addAttribute("loginerror",true);
		return "/loginerror";//must see loginerror.html
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "teacher-units";
	}
	
//	@RequestMapping("/showUser")
//	public String show(Model model, HttpServletRequest request) {
//		model.addAttribute("logged",userComponent.isLoggedUser());
//			if (userComponent.isLoggedUser()){
//				model.addAttribute("name", userComponent.getLoggedUser().getName());
//			}
//		return "index";
//			}
}
