package es.santatecla;


import es.santatecla.enums.RecordsEnum;
import es.santatecla.record.RecordService;
import es.santatecla.relation.RelationService;
import es.santatecla.enums.RelationsEnum;
import es.santatecla.unit.Unit;
import es.santatecla.unit.UnitService;
import es.santatecla.user.User;
import es.santatecla.user.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataBaseInitializer {
    
    private UserRepository userRepository;
    private UnitService unitService;
    private RelationService relationService;
    private RecordService recordService;

    @Autowired
    public DataBaseInitializer(
        UserRepository userRepository,
        UnitService unitService,
        RelationService relationService,
        RecordService recordService
    ) {
        this.userRepository = userRepository;
        this.unitService = unitService;
        this.relationService = relationService;
        this.recordService = recordService;
    }
    
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
        Unit C = this.unitService.addUnit("C");
        Unit angular = this.unitService.addUnit("Angular");
        Unit haskel = this.unitService.addUnit("Haskel");
        Unit python = this.unitService.addUnit("Python");
        Unit html5 = this.unitService.addUnit("Html5");
        Unit ensamblador = this.unitService.addUnit("Ensamblador");
        Unit photoshop = this.unitService.addUnit("Photoshop");
        Unit pascal = this.unitService.addUnit("Pascal");
        Unit cola = this.unitService.addUnit("Cola");
        Unit lista = this.unitService.addUnit("Lista");
        Unit pila = this.unitService.addUnit("Pila");
        Unit grafo = this.unitService.addUnit("Grafo");
        Unit awl = this.unitService.addUnit("AWL");
        Unit docker = this.unitService.addUnit("Docker");

        
        
        
        //Relations
        this.relationService.AddRelations(css.getId(), scss.getId(), RelationsEnum.PARENT);
        this.relationService.AddRelations(css.getId(), spring.getId(), RelationsEnum.CHILD);
        this.relationService.AddRelations(spring.getId(), java.getId(), RelationsEnum.USE);
        
        //Records
        this.recordService.addRecord(html, RecordsEnum.WHY, "Que pasa tío");
        this.recordService.addRecord(css, RecordsEnum.WHY, "Hola Migue");
        this.recordService.addRecord(html, RecordsEnum.WHAT, "Que Dios te bendiga");

    }
}
