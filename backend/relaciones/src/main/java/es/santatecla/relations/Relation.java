package es.santatecla.relations;

import java.util.Dictionary;
import java.util.List;

import es.santatecla.enums.Relations;
import es.santatecla.interfaces.IRelation;

public class Relation<V> implements IRelation {
	
	private Dictionary<Relations, List<V>> relations;

	public Relation (Dictionary<Relations, List<V>> relations) {
		this.relations = relations;
	}
	
	public void addRelation(Relations key, V value) {
		List<V> values = this.relations.get(key);
		values.add(value);
		this.relations.put(key, values);
	}
}
