package es.santatecla.unit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santatecla.record.Record;
import es.santatecla.record.RecordService;
import es.santatecla.relation.Relation;
import es.santatecla.relation.RelationService;

@Service
public class UnitService {
	private UnitRepository unitRepository;
	private RelationService relationService;
	private RecordService recordService;
	
	@Autowired
	public UnitService(UnitRepository unitRepository,
			RelationService relationService,
			RecordService recordService) {
		this.unitRepository = unitRepository;
		this.relationService = relationService;
		this.recordService = recordService;
	}
	
	public Unit getUnit(long unitId) {
		Unit unit = this.unitRepository.findById(unitId);
		List<Relation> relations = this.relationService.getRelationsByUnitId(unitId);
		unit.setRelations(relations);
		List<Record> records = this.recordService.getRecordsByUnitId(unitId);
		unit.setRecords(records);
		return unit;
	}
	
	public Unit addUnit(String name)  {
		List<Relation> relations = new ArrayList<>();
		List<Record> record = new ArrayList<>();
		Unit unit = new Unit(name, relations,record);
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
