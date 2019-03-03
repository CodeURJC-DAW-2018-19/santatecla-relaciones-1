package es.santatecla.user;


import es.santatecla.record.Record;
import es.santatecla.record.RecordRepository;
import es.santatecla.relation.Relation;
import es.santatecla.relation.RelationRepository;
import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataBaseInitializer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private RelationRepository relationRepository;
    @Autowired
    private RecordRepository recordRepository;

    @PostConstruct
    public void init() {
        //Users
        userRepository.save(new User("Miguel","1234", "ROLE_ADMIN","ROLE_USER"));
        userRepository.save(new User("Carlos","pass", "ROLE_USER"));

        //Units
     //   Unit html = unitRepository.save(new Unit (""));

        //Units relations
        //relationRepository.save(new Relation<>("USE",));
        //Records
      //  recordRepository.save(new Record<>(""));
    }
}
