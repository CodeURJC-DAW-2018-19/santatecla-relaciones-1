package es.santatecla.interfaces.relation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santatecla.entities.relation.Relation;

public interface RelationRepository extends JpaRepository<Relation, Long> {
	List<Relation> findById();
}
