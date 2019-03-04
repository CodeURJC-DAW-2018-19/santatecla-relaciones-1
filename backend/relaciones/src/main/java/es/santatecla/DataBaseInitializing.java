package es.santatecla;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import es.santatecla.record.Record;
//import es.santatecla.record.RecordRepository;
import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitRepository;
import es.santatecla.user.User;
import es.santatecla.user.UserRepository;



@Component
public class DataBaseInitializing {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UnitRepository unitRepository;
	
//	@Autowired
//	private RecordRepository recordRepository;
	

	@PostConstruct
	public void init() {
		userRepository.save(new User("Miguel","1234", "ROLE_ADMIN","ROLE_USER"));
		userRepository.save(new User("Carlos","pass", "ROLE_USER"));
		
		unitRepository.save(new Unit("Java"));
//		unitRepository.save(new Unit());
		
//		recordRepository.save(new Record());
		
	}
		
		
	}


