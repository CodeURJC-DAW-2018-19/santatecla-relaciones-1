package es.santatecla.entities.relation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
	
	public Relation (RelationsEnum key, V value) {
		this.key = key;
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RelationsEnum getKey() {
		return key;
	}

	public void setKey(RelationsEnum key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}
