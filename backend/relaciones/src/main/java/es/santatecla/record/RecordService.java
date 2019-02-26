package es.santatecla.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService
{
    @Autowired
    private RecordRepository recordRepository;

//    public void addRecord(Record record){
//        repository.save(record);
//    }
//    public void deleteRecordById(long id) {
//        repository.deleteById(id);
//    }
//    public Page<Record> findAll(Pageable page){
//        return repository.findAll(page);
//    }
//
//    public Optional<Record> findByOneId(Long id) {
//        return repository.findById(id);
//    }
}