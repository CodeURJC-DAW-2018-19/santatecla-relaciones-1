package es.santatecla.unit;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.santatecla.image.ImageService;
import es.santatecla.record.RecordRepository;
import es.santatecla.record.RecordService;

@CrossOrigin
@RestController
public class UnitRestController {
	
	
	private UnitRepository unitRepository;
	private UnitService unitService;
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
			this.recordService = recordService;
			this.imageService = imageService;
		}
	
	@GetMapping("/units")
	public List<Unit> showUnits(Model model) {
		List<Unit> units = this.unitService.getUnits();
		return units;
	}
	
	@GetMapping("/unit/{id}")
	public Unit getUnit(@PathVariable long id) {
		Unit unit = this.unitRepository.findById(id);
		return unit;
	}
	
	
	@PostMapping("/addUnit")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Unit> addUnit(@RequestBody Unit unit) {
		this.unitService.addUnit(unit.getName());
		List<Unit> units = this.unitService.getUnits();
		return units;
	}
	
	@DeleteMapping("/deleteUnit/{id}")
	public List<Unit> deleteUnit(@PathVariable long id)  {
		this.unitService.deleteUnit(id);
		List<Unit> units = this.unitService.getUnits();
		return units;
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


