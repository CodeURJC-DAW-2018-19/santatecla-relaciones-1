package es.santatecla.relation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.santatecla.enums.RelationsEnum;
import es.santatecla.unit.Unit;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> {
	Relation findByType(RelationsEnum type);
	Relation findById(long id);
	List<Relation> findByUnit(Unit unit);
}
