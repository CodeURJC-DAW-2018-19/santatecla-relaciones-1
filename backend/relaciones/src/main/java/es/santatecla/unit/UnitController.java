package es.santatecla.unit;



import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.santatecla.record.Record;
import es.santatecla.relation.Relation;
import es.santatecla.user.UserComponent;


@Controller
public class UnitController {
	
	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private UnitService unitService;
	
	@Autowired
	private UserComponent userComponent;
	
	@ModelAttribute
	public void addUserToModel(Model model) {
		boolean logged = userComponent.getLoggedUser() != null;
		model.addAttribute("logged", logged);
		if(logged) {
			model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
			model.addAttribute("userName",userComponent.getLoggedUser().getName());
		}
	}
	
	@RequestMapping("/")
	public String showUnits(Model model) {
		model.addAttribute("unit",unitRepository.findAll());
		
		return "/index";
	}

	
	@RequestMapping("/unit/{id}")
	public String getUnit(Model model, @PathVariable long id) {
		Unit unit = unitRepository.findById(id);
		model.addAttribute("unit", unit);
		return "/alumn-units";
	}
	
	@RequestMapping("/add-unit")
	public String addUnit(Model model, @RequestParam String name) {
		this.unitService.addUnit(name);
		
		return this.showUnits(model);
	}
	
	@RequestMapping("/delete-unit/{id}")
	public String deleteUnit(Model model, @PathVariable long id)  {
			unitService.deleteUnit(id);
		
		
			return this.showUnits(model);
	}
}
