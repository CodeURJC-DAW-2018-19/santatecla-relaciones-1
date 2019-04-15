package es.santatecla.relation;

import java.util.HashMap;
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
	
	public Relation AddRelations(long idUnit, long idUnitRelated, RelationsEnum relationType) {
		Unit unit = this.unitRepository.findById(idUnit);
		Unit unitRelated = this.unitRepository.findById(idUnitRelated);
		RelationsEnum opositeRelationType = this.opositeRelation.get(relationType);
		
		Relation relation = new Relation(relationType, unit, unitRelated.getId());
		Relation opositeRelation = new Relation(opositeRelationType, unitRelated, unit.getId());
		relationRepository.save(opositeRelation);
		return relationRepository.save(relation);
	}
	
	public void deleteRelation(long idUnit, long idRelation) {
		Relation relation = this.relationRepository.findById(idRelation);
		if (relation != null) {
			deleteOpositeRelations(idUnit, relation);
			this.relationRepository.delete(relation);
		}
	}

	private void deleteOpositeRelations(long idUnit, Relation relation) {
		Unit opositeUnit = this.unitRepository.findById(relation.getUnit().getId());
		opositeUnit.getRelations().forEach((rel) -> {
			if (rel.getUnit().getId() == idUnit && this.opositeRelation.get(relation) == rel.getType()) {
				this.relationRepository.delete(rel);
			}
		});
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
