package es.santatecla.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santatecla.enums.RecordsEnum;
import es.santatecla.unit.Unit;

@Service
public class RecordService
{
    private RecordRepository recordRepository;
	
	@Autowired
	public RecordService(RecordRepository recordRepository) {
    	this.recordRepository = recordRepository;
    }
	
	public Record addRecord(Unit unit, RecordsEnum type, String value) {
		Record record = new Record(unit, type, value, null);
		return this.recordRepository.save(record);
	}

	public Record addImage(Unit unit, RecordsEnum type, String image) {
		Record record = new Record(unit, type, null, image);
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