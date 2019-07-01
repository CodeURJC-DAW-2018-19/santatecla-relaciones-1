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
	
	
	@DeleteMapping("/deleteRelation/{id}/{relatedUnitId}")
	public Unit deleteRelationFromUnit(@PathVariable long id, @PathVariable long relatedUnitId) {
		relationService.deleteRelation(id, relatedUnitId);
	return this.unitService.getUnit(id);
	}

}
