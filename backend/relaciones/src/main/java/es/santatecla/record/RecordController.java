package es.santatecla.record;

import es.santatecla.enums.RecordsEnum;
import es.santatecla.unit.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;

    @RequestMapping("/unit/{id}/add-record")
    public String addRecord(Model model, @PathVariable long id, @RequestParam Unit unit, @RequestParam RecordsEnum type, @RequestParam String value) {
        this.recordService.addRecord(unit,type,value);
        return "alumn-units";
    }

    @RequestMapping("/unit/{id}/add-image")
    public String addImage(Model model, @PathVariable long id, @RequestParam Unit unit, @RequestParam RecordsEnum type, @RequestParam String image) {
        this.recordService.addImage(unit,type,image);
        return "alumn-units";
    }

}
