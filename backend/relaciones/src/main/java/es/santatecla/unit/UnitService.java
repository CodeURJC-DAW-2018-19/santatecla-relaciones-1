package es.santatecla.unit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santatecla.relation.Relation;
import es.santatecla.relation.RelationService;

@Service
public class UnitService {
	private UnitRepository unitRepository;
	private RelationService relationService;
	
	@Autowired
	public UnitService(UnitRepository unitRepository, RelationService relationService) {
		this.unitRepository = unitRepository;
		this.relationService = relationService;
	}
	
	public Unit addUnit(String name)  {
		List<Relation> relations = new ArrayList<>();
		Unit unit = new Unit(name, relations);
		return this.unitRepository.save(unit);
	}
	
	public void deleteUnit(long unitId) {
		Unit unit = this.unitRepository.findById(unitId);
		if (unit != null) {
			deleteRelations(unit);
			
			this.unitRepository.delete(unit);
		}
	}

	private void deleteRelations(Unit unit) {
		for(Relation relation: unit.getRelations()) {
			this.relationService.deleteRelation(unit.getId(), relation.getId());
		}
	}
}
