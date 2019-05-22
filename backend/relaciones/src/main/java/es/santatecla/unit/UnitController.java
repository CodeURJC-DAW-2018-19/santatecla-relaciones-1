package es.santatecla.unit;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.santatecla.enums.RelationsEnum;
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
		List<Unit> parents = unitService.getRelatedUnit(id, RelationsEnum.PARENT);
		List<Unit> associatedBy = unitService.getRelatedUnit(id, RelationsEnum.ASSOCIATED_BY);
		List<Unit> associatedTo = unitService.getRelatedUnit(id, RelationsEnum.ASSOCIATED_TO);
		List<Unit> children = unitService.getRelatedUnit(id, RelationsEnum.CHILD);
		List<Unit> compositions = unitService.getRelatedUnit(id, RelationsEnum.COMPOSITION);
		List<Unit> uses = unitService.getRelatedUnit(id, RelationsEnum.USE);
		List<Unit> usedBy = unitService.getRelatedUnit(id, RelationsEnum.USE_BY);
		List<Unit> parts = unitService.getRelatedUnit(id, RelationsEnum.PART);
		
		model.addAttribute("unit", unit);
		model.addAttribute("units", unitRepository.findAll());
		model.addAttribute("parents", parents);
		model.addAttribute("associated-by", associatedBy);
		model.addAttribute("associated-to", associatedTo);
		model.addAttribute("children", children);
		model.addAttribute("compositions", compositions);
		model.addAttribute("uses", uses);
		model.addAttribute("used-by", usedBy);
		model.addAttribute("part", parts);
		
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
