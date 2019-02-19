package es.santatecla.relaciones.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.santatecla.relaciones.user.User;
import es.santatecla.relaciones.user.UserRepository;

public class UserService {
	
	@Autowired 
	private UserRepository uRepository;
	
	
	public void session (Model model, HttpServletRequest request, RedirectAttributes redirectAttributes){
		if (request.isUserInRole("ROLE_USER")||request.isUserInRole("ROLE_ADMIN")){
			User loggedUser = uRepository.findByName(request.getUserPrincipal().getName());
			
			if (request.isUserInRole("ROLE_USER")){
				model.addAttribute("user",true);
			}
			
			if (request.isUserInRole("ROLE_ADMIN")){
				model.addAttribute("admin",true);
			}
			
		}
	}
	

}
