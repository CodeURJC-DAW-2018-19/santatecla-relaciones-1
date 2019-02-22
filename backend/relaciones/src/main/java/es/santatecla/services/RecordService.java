package es.santatecla.services;

import es.santatecla.models.Record;
import es.santatecla.repositories.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService
{
    @Autowired
    private RecordRepository repository;

    public void addEvent(Record event){
        repository.save(event);
    }
    public void deleteEventById(long id) {
        repository.deleteById(id);
    }
}