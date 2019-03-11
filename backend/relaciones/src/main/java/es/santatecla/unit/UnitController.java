package es.santatecla.unit;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import es.santatecla.enums.RelationsEnum;
//import es.santatecla.record.RecordRepository;
//import es.santatecla.relation.RelationRepository;
import es.santatecla.user.UserComponent;


@Controller
public class UnitController {
//	@Autowired
//	private RecordRepository recordRepository;
//	
//	@Autowired
//	private RelationRepository relationRepository;
	
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
	public String showUnits(Model model) {
		model.addAttribute("unit",unitRepository.findAll());
		return "/index";
	}

	
	@GetMapping("/unit/{id}")
	public String getUnit(Model model, @PathVariable long id) {
		Optional<Unit> unit = unitRepository.findById(id);
		model.addAttribute("unit", unit.get());
		return "/alumn-units";
	}
	
	@GetMapping("/unit/{id}/add-relation")
	public String addRelationToUnit(Model model, @PathVariable long id, @RequestParam RelationsEnum relation, @RequestParam String value) {
		return "/teacher-units";
	}
	
	@GetMapping("/unit/{id}/add-record")
	public String addRecordToUnit(Model model, @PathVariable long id) {
		return "/teacher-units";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("hideLogin", true);
		return "/login";
	}
	
	@GetMapping("/loginerror")
	public String loginError() {
		return "/loginerror";
	}
}
