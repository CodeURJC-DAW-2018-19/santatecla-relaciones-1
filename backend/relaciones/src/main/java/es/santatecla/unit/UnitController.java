package es.santatecla.unit;



import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import es.santatecla.enums.RelationsEnum;
import es.santatecla.relation.Relation;
import es.santatecla.relation.RelationRepository;
//import es.santatecla.record.RecordRepository;
//import es.santatecla.relation.RelationRepository;
import es.santatecla.user.UserComponent;


@Controller
public class UnitController {
//	@Autowired
//	private RecordRepository recordRepository;
//	
	@Autowired
	private RelationRepository relationRepository;
	
	@Autowired
	private UnitRepository unitRepository;
	
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
	
	@GetMapping("/")
	public String showUnits(Model model, HttpServletRequest request) {
		model.addAttribute("unit",unitRepository.findAll());
		
		return "/index";
	}

	
	@GetMapping("/unit/{id}")
	public String getUnit(Model model, @PathVariable long id) {
		Optional<Unit> unit = unitRepository.findById(id);
		model.addAttribute("unit", unit.get());
		return "/alumn-units";
	}
	
	@GetMapping("/unit/add-unit")
	public String addUnit(Model model, @RequestParam String name, @RequestParam List<Relation> relation) {//, @RequestParam Record record ) {
		Unit unit = new Unit(name,relation);
		unitRepository.save(unit);
		
		return "/alumn-units";
	}
	
	@GetMapping("/unit/delete-unit/{id}")
	public String deleteUnit(Model model, @PathVariable long id) {
		unitRepository.deleteById(id);
		return "/teacher-units";
	}
	
//	@GetMapping("/login")
//	public String login(Model model) {
//		model.addAttribute("hideLogin", true);
//		return "/login";
//	}
//	
//	@GetMapping("/loginerror")
//	public String loginError() {
//		return "/loginerror";
//	}
}
