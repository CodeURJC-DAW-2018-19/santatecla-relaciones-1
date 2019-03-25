package es.santatecla.relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.santatecla.enums.RelationsEnum;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> {
	Relation findByType(RelationsEnum type);
}
