package es.santatecla.record;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santatecla.enums.RecordsEnum;
import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitRepository;

@Service
public class RecordService
{
    private RecordRepository recordRepository;
	private UnitRepository unitRepository;
	
	@Autowired
	public RecordService(RecordRepository recordRepository,
			UnitRepository unitRepository) {
    	this.recordRepository = recordRepository;
    	this.unitRepository = unitRepository;
    }
	
	public List<Record> getRecordsByUnitId(long unitId) {
		Unit unit = this.unitRepository.findById(unitId);
		if (unit != null) {
			return this.recordRepository.findByUnit(unit);
		}
		return null;
	}
	
	public Record addRecord(Unit unit, RecordsEnum type, String value) {
		List<Record> records = this.recordRepository.findByUnit(unit);
		deleteOldRecord(type, records);
		Record record = new Record(unit, type, value, null);
		return this.recordRepository.save(record);
	}

	public Record editRecord(long id, String value){
	    Record record = recordRepository.getById(id);
		record.setValue(value);
		this.recordRepository.save(record);
	    return record;
    }

	public Record addImage(Unit unit, RecordsEnum type, String image) {
		Record record = new Record(unit, RecordsEnum.IMAGE, null, image);
		return this.recordRepository.save(record);
	}

	public void addImage(long recordId, String image) {
		Record record = this.recordRepository.findById(recordId);
		record.setImage(image);
		this.recordRepository.save(record);
	}
	
	private void deleteOldRecord(RecordsEnum type, List<Record> records) {
		if (records != null) {
			for (Record rec : records) {
				if (rec.getKey() == type) {
					this.recordRepository.delete(rec);
				}
			}
		}
	}
}