package es.santatecla.record;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record<String>, Long> {
//	List<Record<String>> findById();
}
