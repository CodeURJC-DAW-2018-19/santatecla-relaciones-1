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
	
	@GetMapping("unit/{id}")
	public String ShowRelation(Model model){
		model.addAttribute("relation",relationRepository.findAll());
		return "/teacher-units";
	}
	
	@GetMapping("unit/{id}/add-relation")
	public String addRelationFromUnit(Model model, @PathVariable long id, @RequestParam long value, @RequestParam RelationsEnum relation){
		Unit unit = new Unit();
		unit = unitRepository.findByName(unit.getName());
		Relation r = new Relation(relation,value); 
		relationRepository.save(r);
	return "/teacher-units";
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
