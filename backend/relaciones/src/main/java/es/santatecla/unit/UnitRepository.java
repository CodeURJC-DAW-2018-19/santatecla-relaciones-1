package es.santatecla.unit;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long>{
	Unit findByName(String name);
	Unit findById(long id);
	Page<Unit> findAll(Pageable page);
}
