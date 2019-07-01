package es.santatecla.record;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.santatecla.enums.RecordsEnum;
import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitRepository;
import es.santatecla.unit.UnitService;

@CrossOrigin
@RestController
public class RecordRestController {
	
	 @Autowired
	    private RecordService recordService;
	 @Autowired
	 	private UnitService unitService;
	 @Autowired
	 	private UnitRepository unitRepository;
	 @Autowired 
	 	private RecordRepository recordRepository;

	    @PostMapping("/add-record")
	    public  Unit addRecord(@RequestBody RecordInfo recordInfo) {
			Unit u = unitRepository.findById(recordInfo.getId());
	        this.recordService.addRecord(u,recordInfo.getRecord().getKey(),recordInfo.getRecord().getValue());
	        return this.unitService.getUnit(u.getId());
	    }

	    @PostMapping("/unit/{id}/add-image")
	    public Unit addImage( @PathVariable long id, @RequestParam Unit unit, @RequestParam RecordsEnum type, @RequestParam String image) {
	        this.recordService.addImage(unit,type,image);
	        return this.unitService.getUnit(id);
	    }

	    
	    @PutMapping("/edit-record")
	    public Unit editRecord(@RequestParam String id, @RequestParam String value) {
	    	long recordId = Long.parseLong(id);
	    	this.recordService.editRecord(recordId, value);
	    	return this.unitService.getUnit(recordId); 	
		}
		
		
}