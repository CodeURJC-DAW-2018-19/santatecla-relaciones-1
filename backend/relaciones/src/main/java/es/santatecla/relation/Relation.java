 package es.santatecla.relation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.santatecla.enums.RelationsEnum;
import es.santatecla.unit.Unit;

@Entity
public class Relation {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonIgnore
	@ManyToOne
	private Unit unit;
	
	private RelationsEnum type;
	private long opositeUnitId;
	
	public Relation() {}
	
	public Relation (RelationsEnum type, Unit unit, long opositeUnitId) {
		this.type = type;
		this.unit = unit;
		this.opositeUnitId = opositeUnitId;
	}
	
	public long getOpositeUnitId() {
		return opositeUnitId;
	}

	public void setOpositeUnitId(long opositeUnitId) {
		this.opositeUnitId = opositeUnitId;
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
