package es.santatecla.relation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import es.santatecla.enums.RelationsEnum;
import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitRepository;

public class RelationController {

	@Autowired
	private RelationRepository relationRepository;
	
	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private RelationService relationService;
	
	@GetMapping("unit/{id}")
	public String ShowRelation(Model model){
		model.addAttribute("relation",relationRepository.findAll());
		return "/alumn-units";
	}
	
	@GetMapping("unit/{id}/add-parent")
	public String addParentFromUnit(Model model, @PathVariable long id, @RequestParam long value){
		this.relationService.AddRelations(id, value, RelationsEnum.PARENT );
	return "/alumn-units";
	}
	
	@GetMapping("unit/{id}/add-child")
	public String addChildFromUnit(Model model, @PathVariable long id, @RequestParam long value){
		this.relationService.AddRelations(id, value, RelationsEnum.CHILD );
	return "/alumn-units";
	}
	
	@GetMapping("unit/{id}/add-composition")
	public String addCompositionFromUnit(Model model, @PathVariable long id, @RequestParam long value){
		this.relationService.AddRelations(id, value, RelationsEnum.COMPOSITION );
	return "/alumn-units";
	}
	
	@GetMapping("unit/{id}/add-use")
	public String addUseFromUnit(Model model, @PathVariable long id, @RequestParam long value){
		this.relationService.AddRelations(id, value, RelationsEnum.USE );
	return "/alumn-units";
	}
	
	@GetMapping("unit/{id}/add-useBy")
	public String addUseBYFromUnit(Model model, @PathVariable long id, @RequestParam long value){
		this.relationService.AddRelations(id, value, RelationsEnum.USE_BY );
	return "/alumn-units";
	}
	
	@GetMapping("unit/{id}/add-associatedTo")
	public String addAssociatedToFromUnit(Model model, @PathVariable long id, @RequestParam long value){
		this.relationService.AddRelations(id, value, RelationsEnum.ASSOCIATED_TO );
	return "/alumn-units";
	}
	
	@GetMapping("unit/{id}/add-associatedBy")
	public String addAssociatedByFromUnit(Model model, @PathVariable long id, @RequestParam long value){
		this.relationService.AddRelations(id, value, RelationsEnum.ASSOCIATED_BY );
	return "/alumn-units";
	}
	


	@GetMapping("unit/{id}/delete-relation")
	public String deleteRelationFromUnit(Model model, @PathVariable long id, @RequestParam long value, @RequestParam RelationsEnum relation){
		Unit unit = new Unit();
		unit = unitRepository.findByName(unit.getName());
		Relation r = relationRepository.findByType(relation);
		relationRepository.delete(r);
	return "/teacher-units";	
	}
	
}
