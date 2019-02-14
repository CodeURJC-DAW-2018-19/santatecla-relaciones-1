package es.santatecla.relations;

import java.util.List;
import java.util.Map;

import es.santatecla.enums.Relations;
import es.santatecla.interfaces.IRelation;

public class Relation<V> implements IRelation {
	
	private Map<Relations, List<V>> relations;

	public Relation (Map<Relations, List<V>> relations) {
		this.relations = relations;
	}
	
	public void addRelation(Relations key, V value) {
		List<V> values = this.relations.get(key);
		values.add(value);
		this.relations.put(key, values);
	}
}
