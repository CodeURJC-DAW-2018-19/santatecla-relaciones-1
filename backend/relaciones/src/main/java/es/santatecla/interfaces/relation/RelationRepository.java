package es.santatecla.interfaces.relation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<IRelation<String>, Long> {
	List<IRelation<String>> findById();
}
