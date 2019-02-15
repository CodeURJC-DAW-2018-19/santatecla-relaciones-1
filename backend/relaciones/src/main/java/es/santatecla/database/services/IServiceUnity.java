package es.santatecla.database.services;

import es.santatecla.database.entities.Unity;
import es.santatecla.database.repositories.UnityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IServiceUnity {

    @Autowired
    UnityRepository unityRepository;

    public List<Unity> getAllPersons() {
        List<Unity> unities = new ArrayList<Unity>();
        unityRepository.findAll().forEach(person -> unities.add(person));
        return unities;
    }

    public Unity getPersonById(int id) {
        return unityRepository.findById(id).get();
    }

    public void saveOrUpdate(Unity person) {
        unityRepository.save(person);
    }

    public void delete(int id) {
        unityRepository.deleteById(id);
    }
}