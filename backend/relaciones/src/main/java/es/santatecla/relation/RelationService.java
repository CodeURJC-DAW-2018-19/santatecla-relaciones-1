package es.santatecla.relation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santatecla.enums.RelationsEnum;
import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitRepository;

@Service
public class RelationService {
	private RelationRepository relationRepository;
	private UnitRepository unitRepository;
	private Map<RelationsEnum, RelationsEnum> opositeRelation;
	
	@Autowired
	public RelationService (RelationRepository relationRepository,
			UnitRepository unitRepository) {
		this.relationRepository = relationRepository;
		this.unitRepository = unitRepository;
		this.opositeRelation = new HashMap<>();
		putOpositeRelations();
	}
	
	public void AddRelations(long idUnit, long idUnitRelated, RelationsEnum relationType) {
		Unit unit = this.unitRepository.getOne(idUnit);
		Unit unitRelated = this.unitRepository.getOne(idUnitRelated);
		RelationsEnum opositeRelationType = this.opositeRelation.get(relationType);
		
		Relation relation = new Relation(relationType, unit.getId());
		Relation opositeRelation = new Relation(opositeRelationType, unitRelated.getId());
		relationRepository.save(relation);
		relationRepository.save(opositeRelation);
		
		addRelationToUnit(unit, relation);
		addRelationToUnit(unitRelated, opositeRelation);
		
		this.unitRepository.save(unit);
		this.unitRepository.save(unitRelated);
	}

	private void addRelationToUnit(Unit unit, Relation relation) {
		List<Relation> newRelations = unit.getRelations();
		newRelations.add(relation);
		unit.setRelations(newRelations);
	}

	private void putOpositeRelations() {
		this.opositeRelation.put(RelationsEnum.ASSOCIATED_BY, RelationsEnum.ASSOCIATED_TO);
		this.opositeRelation.put(RelationsEnum.ASSOCIATED_TO, RelationsEnum.ASSOCIATED_BY);
		this.opositeRelation.put(RelationsEnum.PARENT, RelationsEnum.CHILD);
		this.opositeRelation.put(RelationsEnum.CHILD, RelationsEnum.PARENT);
		this.opositeRelation.put(RelationsEnum.USE, RelationsEnum.USE_BY);
		this.opositeRelation.put(RelationsEnum.USE_BY, RelationsEnum.USE);
	}
}
