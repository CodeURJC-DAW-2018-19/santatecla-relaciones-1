package es.santatecla.record;

import java.util.List;

import es.santatecla.enums.RecordsEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.santatecla.unit.Unit;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
	List<Record> findById(long id);
	List<Record> findByUnit(Unit unit);
	Record getById(long id);
	List<Record> findByType(RecordsEnum type);
}
