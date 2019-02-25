package es.santatecla.relaciones.login;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.santatecla.relaciones.user.UserComponent;

@Controller
public class LoginController {
	
	@Autowired
	UserComponent userComponent;
	
	
	@RequestMapping(value= {"/login"})
	public String loginController(Model model, HttpServletRequest request) {
		model.addAttribute("loginerror",false);
		return"/index";
	}

	@RequestMapping(value= {"/loginerror"})
	public String loginErrorController(Model model, HttpServletRequest request) {
		model.addAttribute("loginerror",true);
		return "/loginerror";//must see loginerror.html
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "teacher-units";
	}
	
	@RequestMapping("/showUser")//
	public String show(Model model, HttpServletRequest request) {
		model.addAttribute("logged",userComponent.isLoggedUser());
			if (userComponent.isLoggedUser()){
				model.addAttribute("name", userComponent.getLoggedUser().getName());
			}
		return "index";
			}
}
