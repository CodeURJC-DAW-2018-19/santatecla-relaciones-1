package es.santatecla.interfaces.relation;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santatecla.entities.relation.Relation;

public interface RelationRepository extends JpaRepository<Relation<String>, Long> {

}
