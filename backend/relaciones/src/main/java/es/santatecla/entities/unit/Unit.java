package es.santatecla.entities.unit;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import es.santatecla.interfaces.relation.IRelation;
import es.santatecla.interfaces.unit.IUnit;

@Entity
public class Unit implements IUnit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany
	private List<IRelation<String>> relations;
	
	@Autowired
	public Unit(List<IRelation<String>> relations) {
		this.relations = relations;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<IRelation<String>> getRelations() {
		return relations;
	}

	public void setRelations(List<IRelation<String>> relations) {
		this.relations = relations;
	}
}
