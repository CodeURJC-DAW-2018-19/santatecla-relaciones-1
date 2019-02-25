package es.santatecla.entities.unit;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import es.santatecla.entities.relation.Relation;

@Entity
public class Unit{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="unit")
	private List<Relation<String>> relations;
	
	@Autowired
	public Unit(List<Relation<String>> relations) {
		this.relations = relations;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Relation<String>> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation<String>> relations) {
		this.relations = relations;
	}
}
