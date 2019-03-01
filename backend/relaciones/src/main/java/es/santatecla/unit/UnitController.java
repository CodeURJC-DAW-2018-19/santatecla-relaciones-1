package es.santatecla.unit;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import es.santatecla.enums.RelationsEnum;
import es.santatecla.record.RecordRepository;
import es.santatecla.relation.RelationRepository;
import es.santatecla.user.UserComponent;


@Controller
public class UnitController {
	@Autowired
	private RecordRepository recordRepository;
	
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
	public String showUnits(Model model) {
		model.addAttribute("unit",unitRepository.findAll());
		return "/index";
	}

	
	@RequestMapping("/unit/{id}")
	public String getUnit(Model model, @PathVariable long id) {
		return "";
	}
	
	@RequestMapping("/unit/{id}/add-relation")
	public String addRelationToUnit(Model model, @PathVariable long id, @RequestParam RelationsEnum relation, @RequestParam String value) {
		return "";
	}
	
	@RequestMapping("/unit/{id}/add-record")
	public String addRecordToUnit(Model model, @PathVariable long id) {
		return "";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("hideLogin", true);
		return "login";
	}
	
	@GetMapping("/loginerror")
	public String loginError() {
		return "loginerror";
	}
}
