package es.santatecla.record;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santatecla.enums.RecordsEnum;
import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitService;

@Service
public class RecordService
{
    private RecordRepository recordRepository;
	private UnitService unitService;
	
	@Autowired
	public RecordService(RecordRepository recordRepository,
			UnitService unitService) {
    	this.recordRepository = recordRepository;
    	this.unitService = unitService;
    }
	
	public List<Record> getRecordsByUnitId(long unitId) {
		Unit unit = this.unitService.getUnit(unitId);
		if (unit != null) {
			this.recordRepository.findByUnit(unit);
		}
		return null;
	}
	
	public Record addRecord(Unit unit, RecordsEnum type, String value) {
		Record record = new Record(unit, type, value, null);
		return this.recordRepository.save(record);
	}

	public Record addImage(Unit unit, RecordsEnum type, String image) {
		Record record = new Record(unit, RecordsEnum.IMAGE, null, image);
		return this.recordRepository.save(record);
	}
	
	/**
	 * Delete a record (or image) from the database.
	 * @param recordId
	 */
	public void deleteRecord(long recordId) {
		Record record = this.recordRepository.findById(recordId);
		if (record != null) {
			this.recordRepository.delete(record);
		}
	}
}