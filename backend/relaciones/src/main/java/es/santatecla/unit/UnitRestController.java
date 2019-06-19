package es.santatecla.unit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import es.santatecla.relation.RelationService;
import es.santatecla.user.UserComponent;

@RestController
public class UnitRestController {
	
	
	private UnitRepository unitRepository;
	private UnitService unitService;
	private UserComponent userComponent;
	private RelationService relationService;
	private RecordRepository recordRepository;
	private RecordService recordService;
	private ImageService imageService;
	
	
	public UnitRestController(
			UnitRepository unitRepository,
			UnitService unitService,
			UserComponent userComponent,
			RecordService recordService,
			RecordRepository recordRepository,
			RelationService relationService,
			ImageService imageService
		) {
			this.unitRepository = unitRepository;
			this.unitService = unitService;
			this.userComponent = userComponent;
			this.relationService = relationService;
			this.recordRepository = recordRepository;
			this.recordService = recordService;
			this.imageService = imageService;
		}
	
	@ModelAttribute
	public void addUserToModel(Model model) {
		boolean logged = userComponent.getLoggedUser() != null;
		model.addAttribute("logged", logged);
		if(logged) {
			model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
			model.addAttribute("userName",userComponent.getLoggedUser().getName());
		}
	}
	
	@GetMapping("/")
	public String showUnits(Model model) {
		model.addAttribute("unit",unitRepository.findAll().subList(0, Math.min(unitRepository.findAll().size(),10)));
		model.addAttribute("page", 0);
		return "/index";
	}

	
	@GetMapping("/showMore")
	public String indexScrollPosts(Model model, @RequestParam int page){
    	List<Unit> showMore = null;
    	List<Unit> units = new ArrayList<>();
    	
    	units = unitRepository.findAll();
    	
    	
    	if (page*10 < units.size()){
			if ((page+1)*10 <= units.size()){
				showMore = units.subList(page*10, (page+1)*10);
			} else {
				showMore = units.subList(page*10,units.size());
			}
		}
    	
    	model.addAttribute("page", page);
    	model.addAttribute("unit",showMore);
    	
    return "/showmore";
	}
	
	@GetMapping("/unit/{id}")
	public String getUnit(Model model, @PathVariable long id) {
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
		
		return "/alumn-units";
	}
	
	@PostMapping("/add-parent")
	@ResponseStatus(HttpStatus.CREATED)
	public String addParentFromUnit(Model model, @RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.PARENT);
	return this.getUnit(model, unitId);
	}

	@PostMapping("/add-child")
	@ResponseStatus(HttpStatus.CREATED)
	public String addChildFromUnit(Model model, @RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.CHILD );
	return this.getUnit(model, unitId);
	}
	
	@PostMapping("/add-composition")
	@ResponseStatus(HttpStatus.CREATED)
	public String addCompositionFromUnit(Model model, @RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.COMPOSITION);
	return this.getUnit(model, unitId);
	}
	
	@PostMapping("/add-part")
	@ResponseStatus(HttpStatus.CREATED)
	public String addPartFromUnit(Model model, @RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.PART);
	return this.getUnit(model, unitId);
	}
	
	@PostMapping("/add-use")
	@ResponseStatus(HttpStatus.CREATED)
	public String addUseFromUnit(Model model, @RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.USE);
	return this.getUnit(model, unitId);
	}
	
	@PostMapping("/add-useBy")
	@ResponseStatus(HttpStatus.CREATED)
	public String addUseByFromUnit(Model model, @RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.USE_BY);
	return this.getUnit(model, unitId);
	}
	
	@PostMapping("/add-associatedBy")
	@ResponseStatus(HttpStatus.CREATED)
	public String addAssociatedByFromUnit(Model model, @RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.ASSOCIATED_BY);
	return this.getUnit(model, unitId);
	}
	
	@PostMapping("/add-associatedTo")
	@ResponseStatus(HttpStatus.CREATED)
	public String addAssociatedToFromUnit(Model model, @RequestParam String id, @RequestParam String relatedId){
		int unitId = Integer.parseInt(id);
		int relatedUnitId = Integer.parseInt(relatedId);
		this.relationService.AddRelations(unitId, relatedUnitId, RelationsEnum.ASSOCIATED_TO);
	return this.getUnit(model, unitId);
	}

    @PostMapping("/add-why")
    @ResponseStatus(HttpStatus.CREATED)
    public String addWhyRecord(Model model, @RequestParam String id, @RequestParam String value){
	    long unitId = Long.parseLong(id);
        Unit u = unitRepository.findById(unitId);
        if (recordRepository.getById(unitId)!=null)
            this.recordService.editRecord(unitId, value);
        else
            this.recordService.addRecord(u, RecordsEnum.WHY, value);
        return this.getUnit(model, u.getId());
    }

    @PostMapping("/add-what")
    @ResponseStatus(HttpStatus.CREATED)
    public String addWhatRecord(Model model, @RequestParam String id, @RequestParam String value){
        long unitId = Long.parseLong(id);
        Unit u = unitRepository.findById(unitId);
        if (recordRepository.getById(unitId)!=null)
            this.recordService.editRecord(unitId, value);
        else
            this.recordService.addRecord(u, RecordsEnum.WHAT, value);
        return this.getUnit(model, u.getId());
    }

    @PostMapping("/add-forWhat")
    @ResponseStatus(HttpStatus.CREATED)
    public String addForWhatRecord(Model model, @RequestParam String id, @RequestParam String value){
        long unitId = Long.parseLong(id);
        Unit u = unitRepository.findById(unitId);
        if (recordRepository.getById(unitId)!=null)
            this.recordService.editRecord(unitId, value);
        else
            this.recordService.addRecord(u, RecordsEnum.FOR_WHAT, value);
        return this.getUnit(model, u.getId());
    }

    @PostMapping("/add-where")
    @ResponseStatus(HttpStatus.CREATED)
    public String addWhereRecord(Model model, @RequestParam String id, @RequestParam String value){
        long unitId = Long.parseLong(id);
        Unit u = unitRepository.findById(unitId);
        if (recordRepository.getById(unitId)!=null)
            this.recordService.editRecord(unitId, value);
        else
            this.recordService.addRecord(u, RecordsEnum.WHERE, value);
        return this.getUnit(model, u.getId());
    }

    @PostMapping("/add-who")
    @ResponseStatus(HttpStatus.CREATED)
    public String addWhoRecord(Model model, @RequestParam String id, @RequestParam String value){
        long unitId = Long.parseLong(id);
        Unit u = unitRepository.findById(unitId);
        if (recordRepository.getById(unitId)!=null)
            this.recordService.editRecord(unitId, value);
        else
            this.recordService.addRecord(u, RecordsEnum.WHO, value);
        return this.getUnit(model, u.getId());
    }

    @PostMapping("/add-how")
    @ResponseStatus(HttpStatus.CREATED)
    public String addHowRecord(Model model, @RequestParam String id, @RequestParam String value){
        long unitId = Long.parseLong(id);
        Unit u = unitRepository.findById(unitId);
        if (recordRepository.getById(unitId)!=null)
            this.recordService.editRecord(unitId, value);
        else
            this.recordService.addRecord(u, RecordsEnum.HOW, value);
        return this.getUnit(model, u.getId());
    }

    @PostMapping("/add-when")
    @ResponseStatus(HttpStatus.CREATED)
    public String addWhenRecord(Model model, @RequestParam String id, @RequestParam String value){
        long unitId = Long.parseLong(id);
        Unit u = unitRepository.findById(unitId);
        if (recordRepository.getById(unitId)!=null)
            this.recordService.editRecord(unitId, value);
        else
            this.recordService.addRecord(u, RecordsEnum.WHEN, value);
        return this.getUnit(model, u.getId());
    }
	
	@DeleteMapping("/delete-relation")
	public String deleteRelationFromUnit(Model model, @RequestParam String id, @RequestParam String relatedId) {
		long unitId = Integer.parseInt(id);
		long relatedUnitId = Integer.parseInt(relatedId);
		relationService.deleteRelation(unitId, relatedUnitId);
		return this.getUnit(model, unitId);
	}
	
	@PostMapping("/add-unit")
	@ResponseStatus(HttpStatus.CREATED)
	public String addUnit(Model model, @RequestParam String name) {
		this.unitService.addUnit(name);
		return this.showUnits(model);
	}
	
	@DeleteMapping("/delete-unit/{id}")
	public String deleteUnit(Model model, @PathVariable long id)  {
		unitService.deleteUnit(id);
	
		return this.showUnits(model);
	}

	@PostMapping("/upload-image")
	@ResponseStatus(HttpStatus.CREATED)
    public String handleFileUpload(Model model, @RequestParam String recordId, @RequestParam("file") MultipartFile multipartFile) {
		long id = Long.parseLong(recordId);
		String imageDir = this.imageService.uploadPhoto(multipartFile);
		this.recordService.addImage(id, imageDir);
		
		return this.showUnits(model);
    }
}


