package es.santatecla.relation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import es.santatecla.enums.RelationsEnum;

@Entity
public class Relation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private long unit;
	
	private RelationsEnum type;
	
	private long unitId;
	
	public Relation () {}
	
	public Relation (RelationsEnum key, long value) {
		this.type = key;
		this.unitId = value;
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
		return unitId;
	}

	public void setValue(long value) {
		this.unitId = value;
	}
	public long getUnit() {
		return unit;
	}

	public void setUnit(long unit) {
		this.unit = unit;
	}

	public RelationsEnum getType() {
		return type;
	}

	public void setType(RelationsEnum type) {
		this.type = type;
	}
}
