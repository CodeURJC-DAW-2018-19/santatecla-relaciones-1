package es.santatecla;


import es.santatecla.relation.Relation;
import es.santatecla.relation.RelationRepository;
import es.santatecla.relation.RelationService;
import es.santatecla.enums.RelationsEnum;
import es.santatecla.record.RecordRepository;
import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitRepository;
import es.santatecla.unit.UnitService;
import es.santatecla.user.User;
import es.santatecla.user.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.annotation.PostConstruct;

@Component
public class DataBaseInitializer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UnitService unitService;
    @Autowired
    private RelationService relationService;
    
    @Autowired
    private RelationRepository relationRepository;
    
    @PostConstruct
    public void init() {
        //Users
        userRepository.save(new User("Miguel","pass", "ROLE_ADMIN","ROLE_USER"));
        userRepository.save(new User("jorge","pass", "ROLE_USER"));

        //Units
        Unit html = this.unitService.addUnit("HTML");
        Unit css = this.unitService.addUnit("CSS");
        Unit scss = this.unitService.addUnit("SCSS");
        Unit javaScript = this.unitService.addUnit("JavaScript");
        Unit spring = this.unitService.addUnit("Spring");
        Unit xml = this.unitService.addUnit("XML");
        Unit java = this.unitService.addUnit("Java");

        //Units relations
        this.relationService.AddRelations(css.getId(), scss.getId(), RelationsEnum.PARENT);
        this.relationService.AddRelations(css.getId(), spring.getId(), RelationsEnum.CHILD);
        this.relationService.AddRelations(spring.getId(), java.getId(), RelationsEnum.USE);
    }
}
