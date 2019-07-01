package es.santatecla.record;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.santatecla.enums.RecordsEnum;
import es.santatecla.unit.Unit;

@Entity
public class Record {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonIgnore
	@ManyToOne
	private Unit unit;
	
	private RecordsEnum type;
	
	private String value;
	
	private String image;

	public Record() {
		
	}
	
	public Record(Unit unit, RecordsEnum type, String value, String image) {
		super();
		this.unit = unit;
		this.type = type;
		this.value = value;
		this.image = image;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public RecordsEnum getKey() {
		return type;
	}

	public void setKey(RecordsEnum key) {
		this.type = key;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
