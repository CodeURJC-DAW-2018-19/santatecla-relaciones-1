package es.santatecla.relation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.santatecla.enums.RelationsEnum;
import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitService;

@CrossOrigin
@RestController
public class RelationRestController {
	
	private UnitService unitService;
	private RelationService relationService;
	
	@Autowired
	public RelationRestController(
			UnitService unitService,
			RelationService relationService
		) {
			this.unitService = unitService;
			this.relationService = relationService;
		}
	
	@PostMapping("/addRelation")
	@ResponseStatus(HttpStatus.CREATED)
	public Unit addRelationFromUnit (@RequestBody RelationInfo relationInfo){
		long unitId = relationInfo.getId();
		long relatedUnitId = relationInfo.getRelation().getOpositeUnitId();
		this.relationService.AddRelations(unitId, relatedUnitId, relationInfo.getRelation().getType());
	return this.unitService.getUnit(unitId);
	}
	
	
	@PostMapping("/add-parent")
	@ResponseStatus(HttpStatus.CREATED)
	public Unit addParentFromUnit (@RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.PARENT);
	return this.unitService.getUnit(unitId);
	}

	@PostMapping("/add-child")
	@ResponseStatus(HttpStatus.CREATED)
	public Unit addChildFromUnit(@RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.CHILD );
	return this.unitService.getUnit(unitId);
	}
	
	@PostMapping("/add-composition")
	@ResponseStatus(HttpStatus.CREATED)
	public Unit addCompositionFromUnit(@RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.COMPOSITION);
	return this.unitService.getUnit(unitId);
	}
	
	@PostMapping("/add-part")
	@ResponseStatus(HttpStatus.CREATED)
	public Unit addPartFromUnit(@RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.PART);
		return this.unitService.getUnit(unitId);
	}
	
	@PostMapping("/add-use")
	@ResponseStatus(HttpStatus.CREATED)
	public Unit addUseFromUnit(@RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.USE);
	return this.unitService.getUnit(unitId);
	}
	
	@PostMapping("/add-useBy")
	@ResponseStatus(HttpStatus.CREATED)
	public Unit addUseByFromUnit(@RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.USE_BY);
	return this.unitService.getUnit(unitId);
	}
	
	@PostMapping("/add-associatedBy")
	@ResponseStatus(HttpStatus.CREATED)
	public Unit addAssociatedByFromUnit(@RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.ASSOCIATED_BY);
	return this.unitService.getUnit(unitId);
	}
	
	@PostMapping("/add-associatedTo")
	@ResponseStatus(HttpStatus.CREATED)
	public Unit addAssociatedToFromUnit(@RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.ASSOCIATED_TO);
	return this.unitService.getUnit(unitId);
	}
	
	@DeleteMapping("/deleteRelation/{id}/{relatedUnitId}")
	public Unit deleteRelationFromUnit(@PathVariable long id, @PathVariable long relatedUnitId) {
		relationService.deleteRelation(id, relatedUnitId);
	return this.unitService.getUnit(id);
	}

}
