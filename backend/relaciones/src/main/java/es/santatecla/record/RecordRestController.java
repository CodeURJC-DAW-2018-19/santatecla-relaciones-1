package es.santatecla.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.santatecla.enums.RecordsEnum;
import es.santatecla.unit.Unit;

@RestController
public class RecordRestController {
	
	 @Autowired
	    private RecordService recordService;

	    @PostMapping("/unit/{id}/add-record")
	    public String addRecord(Model model, @PathVariable long id, @RequestParam Unit unit, @RequestParam RecordsEnum type, @RequestParam String value) {
	        this.recordService.addRecord(unit,type,value);
	        return "alumn-units";
	    }

	    @PostMapping("/unit/{id}/add-image")
	    public String addImage(Model model, @PathVariable long id, @RequestParam Unit unit, @RequestParam RecordsEnum type, @RequestParam String image) {
	        this.recordService.addImage(unit,type,image);
	        return "alumn-units";
	    }


}
