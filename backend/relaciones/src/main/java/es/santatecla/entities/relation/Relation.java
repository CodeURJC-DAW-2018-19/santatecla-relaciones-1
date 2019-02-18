package es.santatecla.entities.relation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import es.santatecla.enums.RelationsEnum;
import es.santatecla.interfaces.relation.IRelation;

@Entity
public class Relation<V> implements IRelation<V> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private RelationsEnum key;
	
	private V value;
	
	@Autowired
	public Relation (RelationsEnum key, V value) {
		this.key = key;
		this.value = value;
	}
}
