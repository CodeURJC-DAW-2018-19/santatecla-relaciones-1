package es.santatecla.relation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.santatecla.enums.RelationsEnum;
import es.santatecla.unit.UnitController;
import es.santatecla.unit.UnitRepository;


public class RelationController {
	
	private RelationService relationService;
	private UnitController UnitController;
	
	@Autowired
	public RelationController(RelationService relationService, UnitController unitController){
		this.UnitController = unitController;
		this.relationService = relationService;
	}
	
	@RequestMapping("add-child")
	public String addChildFromUnit(Model model, @RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.CHILD );
	return this.UnitController.getUnit(model, unitId);
	}
	
}
