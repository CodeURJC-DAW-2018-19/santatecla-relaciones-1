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
	
	public List<Relation> getRelationsByUnitId(long unitId) {
		Unit unit = this.unitRepository.findById(unitId);
		if (unit != null) {
			return this.relationRepository.findByUnit(unit);
		}
		return null;
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

	public void deleteRelation(long idUnit, long idRelatedUnit) {
		Unit unit = this.unitRepository.findById(idUnit);
		if (unit == null) return;
		List<Relation> relations = this.relationRepository.findByUnit(unit);
		if (relations == null) return;
		Relation relation = null;

		for (Relation rel : relations) {
			if (rel.getOpositeUnitId() == idRelatedUnit) {
				relation = rel;
			}
		}

		if (relation != null) {
			this.deleteRelationAndOposite(idUnit, relation.getId());
		}
	}
	
	private void deleteRelationAndOposite(long idUnit, long idRelation) {
		Relation relation = this.relationRepository.findById(idRelation);
		if (relation != null) {
			deleteOpositeRelations(idUnit, relation);
			this.relationRepository.delete(relation);
		}
	}

	private void deleteOpositeRelations(long idUnit, Relation relation) {
		Unit opositeUnit = this.unitRepository.findById(relation.getOpositeUnitId());
		if (opositeUnit == null) return;
		List<Relation> relations = this.relationRepository.findByUnit(opositeUnit);
		if (relations == null) return;

		for (Relation rel : relations) {
			if (rel.getOpositeUnitId() == idUnit) {
				this.relationRepository.delete(rel);
			}
		}
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
