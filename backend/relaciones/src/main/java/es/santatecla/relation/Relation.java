package es.santatecla.relation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import es.santatecla.enums.RelationsEnum;
import es.santatecla.unit.Unit;

@Entity
public class Relation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Unit unit;
	
	private RelationsEnum type;
	
	private long relatedUnitId;
	
	public Relation () {}
	
	public Relation (RelationsEnum key, long value) {
		this.type = key;
		this.relatedUnitId = value;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RelationsEnum getKey() {
		return type;
	}

	public void setKey(RelationsEnum key) {
		this.type = key;
	}

	public long getValue() {
		return relatedUnitId;
	}

	public void setValue(long value) {
		this.relatedUnitId = value;
	}
	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public RelationsEnum getType() {
		return type;
	}

	public void setType(RelationsEnum type) {
		this.type = type;
	}
}
