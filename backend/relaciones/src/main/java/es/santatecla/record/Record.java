package es.santatecla.record;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

import es.santatecla.enums.RecordsEnum;
import es.santatecla.unit.Unit;

@Entity
public class Record<V> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Unit unit;
	
	private RecordsEnum key;
	
	private V value;
	
	private String image;

	public Record() {
		
	}
	
	public Record(Unit unit, RecordsEnum key, V value, String image) {
		super();
		this.unit = unit;
		this.key = key;
		this.value = value;
		this.image = image;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public RecordsEnum getKey() {
		return key;
	}

	public void setKey(RecordsEnum key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
