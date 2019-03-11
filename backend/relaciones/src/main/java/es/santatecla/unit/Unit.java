package es.santatecla.unit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import es.santatecla.record.Record;
//import es.santatecla.relation.Relation;

@Entity
public class Unit{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="unit")
//	private List<Relation<String>> relations;
//	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="unit")
//	private List<Record<String>> records;
	
	public Unit() {}
	
	public Unit(String name){
		super();
		this.setName(name);
	}


//	public Unit(List<Relation<String>> relations, List<Record<String>> records) {
//		super();
//		this.relations = relations;
//		this.records = records;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Relation<String>> getRelations() {
//		return relations;
//	}
//
//	public void setRelations(List<Relation<String>> relations) {
//		this.relations = relations;
//	}
//
//	public List<Record<String>> getRecords() {
//		return records;
//	}
//
//	public void setRecords(List<Record<String>> records) {
//		this.records = records;
//	}
}
