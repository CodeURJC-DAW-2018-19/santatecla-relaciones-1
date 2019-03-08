//package es.santatecla.relation;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.ManyToOne;
//
//import org.springframework.data.annotation.Id;
//
//import es.santatecla.enums.RelationsEnum;
//import es.santatecla.unit.Unit;
//
//@Entity
//public class Relation<V>{
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	
//	@ManyToOne
//	private Unit unit;
//	
//	private RelationsEnum key;
//	
//	private V value;
//	
//	public Relation () {}
//	
//	public Relation (RelationsEnum key, V value) {
//		this.key = key;
//		this.value = value;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public RelationsEnum getKey() {
//		return key;
//	}
//
//	public void setKey(RelationsEnum key) {
//		this.key = key;
//	}
//
//	public V getValue() {
//		return value;
//	}
//
//	public void setValue(V value) {
//		this.value = value;
//	}
//}
