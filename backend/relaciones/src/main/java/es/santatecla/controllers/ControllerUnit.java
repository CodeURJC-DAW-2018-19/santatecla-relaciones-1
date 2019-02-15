package es.santatecla.controllers;

import es.santatecla.database.entities.Unity;
import es.santatecla.database.services.IServiceUnity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerUnit {

    @Autowired
    IServiceUnity iServiceUnity;

    @GetMapping("/unities")
    private List<Unity> getAllUnities() {
        return iServiceUnity.getAllPersons();
    }

    @GetMapping("/unities/{id}")
    private Unity getUnity(@PathVariable("id") int id) {
        return iServiceUnity.getPersonById(id);
    }

    @DeleteMapping("/units/{id}")
    private void deleteUnity(@PathVariable("id") int id) {
        iServiceUnity.delete(id);
    }

    @PostMapping("/units")
    private int savePerson(@RequestBody Unity unit) {
        iServiceUnity.saveOrUpdate(unit);
        return  unit.getId();
    }
}