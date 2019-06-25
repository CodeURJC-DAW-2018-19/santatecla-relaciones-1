package es.santatecla.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.santatecla.enums.RecordsEnum;
import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitRepository;
import es.santatecla.unit.UnitService;

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

	    @PostMapping("/unit/{id}/add-record")
	    public  Unit addRecord(@PathVariable long id, @RequestParam Unit unit, @RequestParam RecordsEnum type, @RequestParam String value) {
	        this.recordService.addRecord(unit,type,value);
	        return this.unitService.getUnit(id);
	    }

	    @PostMapping("/unit/{id}/add-image")
	    public Unit addImage( @PathVariable long id, @RequestParam Unit unit, @RequestParam RecordsEnum type, @RequestParam String image) {
	        this.recordService.addImage(unit,type,image);
	        return this.unitService.getUnit(id);
	    }


	    @PostMapping("/add-why")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Unit addWhyRecord(@RequestParam String id, @RequestParam String value){
		    long unitId = Long.parseLong(id);
	        Unit u = unitRepository.findById(unitId);
	        if (recordRepository.getById(unitId)!=null)
	            this.recordService.editRecord(unitId, value);
	        else
	            this.recordService.addRecord(u, RecordsEnum.WHY, value);
	        return this.unitService.getUnit(unitId);
	    }

	    @PostMapping("/add-what")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Unit addWhatRecord(@RequestParam String id, @RequestParam String value){
	        long unitId = Long.parseLong(id);
	        Unit u = unitRepository.findById(unitId);
	        if (recordRepository.getById(unitId)!=null)
	            this.recordService.editRecord(unitId, value);
	        else
	            this.recordService.addRecord(u, RecordsEnum.WHAT, value);
	        return this.unitService.getUnit(unitId);
	    }

	    @PostMapping("/add-forWhat")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Unit addForWhatRecord(@RequestParam String id, @RequestParam String value){
	        long unitId = Long.parseLong(id);
	        Unit u = unitRepository.findById(unitId);
	        if (recordRepository.getById(unitId)!=null)
	            this.recordService.editRecord(unitId, value);
	        else
	            this.recordService.addRecord(u, RecordsEnum.FOR_WHAT, value);
	        return this.unitService.getUnit(unitId);
	    }

	    @PostMapping("/add-where")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Unit addWhereRecord(@RequestParam String id, @RequestParam String value){
	        long unitId = Long.parseLong(id);
	        Unit u = unitRepository.findById(unitId);
	        if (recordRepository.getById(unitId)!=null)
	            this.recordService.editRecord(unitId, value);
	        else
	            this.recordService.addRecord(u, RecordsEnum.WHERE, value);
	        return this.unitService.getUnit(unitId);
	    }

	    @PostMapping("/add-who")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Unit addWhoRecord(@RequestParam String id, @RequestParam String value){
	        long unitId = Long.parseLong(id);
	        Unit u = unitRepository.findById(unitId);
	        if (recordRepository.getById(unitId)!=null)
	            this.recordService.editRecord(unitId, value);
	        else
	            this.recordService.addRecord(u, RecordsEnum.WHO, value);
	        return this.unitService.getUnit(unitId);
	    }

	    @PostMapping("/add-how")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Unit addHowRecord(@RequestParam String id, @RequestParam String value){
	        long unitId = Long.parseLong(id);
	        Unit u = unitRepository.findById(unitId);
	        if (recordRepository.getById(unitId)!=null)
	            this.recordService.editRecord(unitId, value);
	        else
	            this.recordService.addRecord(u, RecordsEnum.HOW, value);
	        return this.unitService.getUnit(unitId);
	    }

	    @PostMapping("/add-when")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Unit addWhenRecord(@RequestParam String id, @RequestParam String value){
	        long unitId = Long.parseLong(id);
	        Unit u = unitRepository.findById(unitId);
	        if (recordRepository.getById(unitId)!=null)
	            this.recordService.editRecord(unitId, value);
	        else
	            this.recordService.addRecord(u, RecordsEnum.WHEN, value);
	        return this.unitService.getUnit(unitId);
	    }
	    
	    @PutMapping("/edit-record")
	    public Unit editRecord(@RequestParam String id, @RequestParam String value) {
	    	long unitId = Long.parseLong(id);
	    	this.recordService.editRecord(unitId, value);
	    	return this.unitService.getUnit(unitId); 	
	    }
}
