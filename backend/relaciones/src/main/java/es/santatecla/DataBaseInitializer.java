package es.santatecla;


import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitRepository;
import es.santatecla.user.User;
import es.santatecla.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataBaseInitializer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UnitRepository unitRepository;
//    @Autowired
//    private RelationRepository relationRepository;
//    @Autowired
//    private RecordRepository recordRepository;

    @PostConstruct
    public void init() {
        //Users
        userRepository.save(new User("Miguel","pass", "ROLE_ADMIN","ROLE_USER"));
        userRepository.save(new User("Carlos","pass", "ROLE_USER"));

        //Units
        Unit html = new Unit();
        Unit css = new Unit();
        Unit js= new Unit();
        Unit spring = new Unit();
        Unit xml = new Unit();



        unitRepository.save(html);
        unitRepository.save(css);
        unitRepository.save(js);
        unitRepository.save(spring);
        unitRepository.save(xml);
        //Units relations

        //Records

    }
}
