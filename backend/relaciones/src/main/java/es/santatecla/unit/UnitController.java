package es.santatecla.unit;

import javax.enterprise.inject.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import es.santatecla.enums.RelationsEnum;
import es.santatecla.record.RecordRepository;
import es.santatecla.relation.RelationRepository;


@Controller
public class UnitController {
	@Autowired
	private RecordRepository recordRepository;
	
	@Autowired
	private RelationRepository relationRepository;
	
	@Autowired
	private UnitRepository unitRepository;
	
	@RequestMapping("/unit/{id}")
	public String getUnit(Model model, @PathVariable long id) {
		return "";
	}
	
	@RequestMapping("/unit/{id}/add-relation")
	public String addRelationToUnit(Model model, @PathVariable long id, @RequestParam RelationsEnum relation, @RequestParam String value) {
		return "";
	}
	
	@RequestMapping("/unit/{id}/add-record")
	public String addRecordToUnit(Model model, @PathVariable long id) {
		return "";
	}
}
