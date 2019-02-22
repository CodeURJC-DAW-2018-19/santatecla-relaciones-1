package es.santatecla.repositories;

import es.santatecla.relaciones.unit.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Long> {
    Optional<Record> findByIdRecord(long id);
}