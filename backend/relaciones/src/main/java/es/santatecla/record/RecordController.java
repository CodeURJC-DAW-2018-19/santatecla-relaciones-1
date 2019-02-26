package es.santatecla.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.santatecla.enums.RecordsEnum;

@Controller
public class RecordController {
	@Autowired
	private RecordRepository recordRepository;
	
	public RecordRepository getRecordRepository() {
		return recordRepository;
	}

	public void setRecordRepository(RecordRepository recordRepository) {
		this.recordRepository = recordRepository;
	}
	
	public RecordController() {}

	public RecordController(RecordRepository recordRepository) {
		super();
		this.recordRepository = recordRepository;
	}

	@RequestMapping("/addRecord")
	public String addToken(Model model, @RequestParam RecordsEnum record, @RequestParam String value) {
		return "";
	}
	
	@RequestMapping("/deleteRecord/{id}")
	public String deleteRecord(Model model, @PathVariable long id) {
		return "";
	}
}
