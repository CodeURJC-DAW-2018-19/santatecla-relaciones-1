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
	private List<IRelation> relations;
	
	@Autowired
	public Unit(List<IRelation> relations) {
		this.relations = relations;
	}
}
