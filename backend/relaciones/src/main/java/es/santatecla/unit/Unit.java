package es.santatecla.unit;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import es.santatecla.record.Record;
import es.santatecla.relation.Relation;



@Entity
public class Unit{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="unit")
	private List<Relation> relations;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="unit")
	private List<Record> records;
	
	public Unit() {}
	
	public Unit(String name, List<Relation> relations, List<Record> records) {
		super();
		this.name = name;
		this.relations = relations;
		this.records = records;
	}

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

	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}
}
