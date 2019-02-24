package es.santatecla.services;

import es.santatecla.models.Record;
import es.santatecla.repositories.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecordService
{
    @Autowired
    private RecordRepository repository;

    public void addRecord(Record record){
        repository.save(record);
    }
    public void deleteRecordById(long id) {
        repository.deleteById(id);
    }
    public Page<Record> findAll(Pageable page){
        return repository.findAll(page);
    }

    public Optional<Record> findByOneId(Long id) {
        return repository.findById(id);
    }
}