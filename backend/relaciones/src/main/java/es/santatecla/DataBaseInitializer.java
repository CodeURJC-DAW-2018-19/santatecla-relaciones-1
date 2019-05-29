package es.santatecla;


import es.santatecla.enums.RecordsEnum;
import es.santatecla.record.RecordService;
import es.santatecla.relation.RelationRepository;
import es.santatecla.relation.RelationService;
import es.santatecla.enums.RelationsEnum;
import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitRepository;
import es.santatecla.unit.UnitService;
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
    private UnitService unitService;
    @Autowired
    private RelationService relationService;
    
    @Autowired
    private RelationRepository relationRepository;

    @Autowired
    private RecordService recordService;
    
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

        this.recordService.addRecord(html, RecordsEnum.WHY, "Que pasa tío");
        this.recordService.addRecord(css, RecordsEnum.WHY, "Hola Migue");
        this.recordService.addRecord(html, RecordsEnum.WHAT, "Que Dios te bendiga");

    }
}
