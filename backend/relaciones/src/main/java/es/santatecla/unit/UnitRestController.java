package es.santatecla.unit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.santatecla.enums.RecordsEnum;
import es.santatecla.enums.RelationsEnum;
import es.santatecla.image.ImageService;
import es.santatecla.record.Record;
import es.santatecla.record.RecordRepository;
import es.santatecla.record.RecordService;

@RestController
public class UnitRestController {
	
	
	private UnitRepository unitRepository;
	private UnitService unitService;
	private RecordRepository recordRepository;
	private RecordService recordService;
	private ImageService imageService;
	
	@Autowired
	public UnitRestController(
			UnitRepository unitRepository,
			UnitService unitService,
			RecordService recordService,
			RecordRepository recordRepository,
			ImageService imageService
		) {
			this.unitRepository = unitRepository;
			this.unitService = unitService;
			this.recordRepository = recordRepository;
			this.recordService = recordService;
			this.imageService = imageService;
		}
	
	@GetMapping("/")
	public List<Unit> showUnits(Model model) {
		List<Unit> units = unitService.getUnits();
		return units;
	}

	
//	@GetMapping("/showMore")
//	public String indexScrollPosts(Model model, @RequestParam int page){
//    	List<Unit> showMore = null;
//    	List<Unit> units = new ArrayList<>();
//    	
//    	units = unitRepository.findAll();
//    	
//    	
//    	if (page*10 < units.size()){
//			if ((page+1)*10 <= units.size()){
//				showMore = units.subList(page*10, (page+1)*10);
//			} else {
//				showMore = units.subList(page*10,units.size());
//			}
//		}
//    	
//    	model.addAttribute("page", page);
//    	model.addAttribute("unit",showMore);
//    	
//    return "/showmore";
//	}
	
	@GetMapping("/unit/{id}")
	public Unit getUnit(Model model, @PathVariable long id) {
		Unit unit = unitRepository.findById(id);
		List<Unit> parents = unitService.getRelatedUnit(id, RelationsEnum.PARENT);
		List<Unit> associatedBy = unitService.getRelatedUnit(id, RelationsEnum.ASSOCIATED_BY);
		List<Unit> associatedTo = unitService.getRelatedUnit(id, RelationsEnum.ASSOCIATED_TO);
		List<Unit> children = unitService.getRelatedUnit(id, RelationsEnum.CHILD);
		List<Unit> compositions = unitService.getRelatedUnit(id, RelationsEnum.COMPOSITION);
		List<Unit> uses = unitService.getRelatedUnit(id, RelationsEnum.USE);
		List<Unit> usedBy = unitService.getRelatedUnit(id, RelationsEnum.USE_BY);
		List<Unit> parts = unitService.getRelatedUnit(id, RelationsEnum.PART);
		List<Record> records = recordService.getRecordsByUnitId(id);
        List<Record> why = new ArrayList<>();
        List<Record> what = new ArrayList<>();
        List<Record> how = new ArrayList<>();
        List<Record> for_what = new ArrayList<>();
        List<Record> where = new ArrayList<>();
        List<Record> who = new ArrayList<>();
        List<Record> when = new ArrayList<>();
        for (Record record: records
             ) {
            if (record.getKey()==RecordsEnum.WHY){
                why.add(record);
            }
        }
        for (Record record: records
        ) {
            if (record.getKey()==RecordsEnum.WHAT){
                what.add(record);
            }
        }
        for (Record record: records
        ) {
            if (record.getKey()==RecordsEnum.HOW){
                how.add(record);
            }
        }
        for (Record record: records
        ) {
            if (record.getKey()==RecordsEnum.FOR_WHAT){
                for_what.add(record);
            }
        }
        for (Record record: records
        ) {
            if (record.getKey()==RecordsEnum.WHERE){
                where.add(record);
            }
        }
        for (Record record: records
        ) {
            if (record.getKey()==RecordsEnum.WHO){
                who.add(record);
            }
        }
        for (Record record: records
        ) {
            if (record.getKey()==RecordsEnum.WHEN){
                when.add(record);
            }
        }
		model.addAttribute("unit", unit);
		model.addAttribute("units", unitRepository.findAll());
		model.addAttribute("parents", parents);
		model.addAttribute("associated-by", associatedBy);
		model.addAttribute("associated-to", associatedTo);
		model.addAttribute("children", children);
		model.addAttribute("compositions", compositions);
		model.addAttribute("uses", uses);
		model.addAttribute("used-by", usedBy);
		model.addAttribute("part", parts);
		model.addAttribute("records", recordRepository.findAll());
		model.addAttribute("why", why);
        model.addAttribute("what", what);
        model.addAttribute("how", how);
        model.addAttribute("for_what", for_what);
        model.addAttribute("where", where);
        model.addAttribute("who", who);
        model.addAttribute("when", when);
		
		return unit;
	}
	
	
	@PostMapping("/add-unit")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Unit> addUnit(Model model, @RequestParam String name) {
		this.unitService.addUnit(name);
		return this.showUnits(model);
	}
	
	@DeleteMapping("/delete-unit/{id}")
	public List<Unit> deleteUnit(Model model, @PathVariable long id)  {
		unitService.deleteUnit(id);
	
		return this.showUnits(model);
	}

	@PostMapping("/upload-image")
	@ResponseStatus(HttpStatus.CREATED)
    public List<String> handleFileUpload(Model model, @RequestParam String recordId, @RequestParam("file") MultipartFile multipartFile) {
		long id = Long.parseLong(recordId);
		String imageDir = this.imageService.uploadPhoto(multipartFile);
		this.recordService.addImage(id, imageDir);
		
		return this.handleFileUpload(model, recordId, multipartFile);
    }
}


