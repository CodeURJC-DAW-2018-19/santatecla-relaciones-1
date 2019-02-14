package es.santatecla.relations;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import es.santatecla.enums.Relations;
import es.santatecla.interfaces.IRelation;

public class Relation<V> implements IRelation<V> {
	
	private Map<Relations, List<V>> relations;

	public Relation (Map<Relations, List<V>> relations) {
		this.relations = relations;
	}
	
	public void addRelation(Relations key, V value) {
		List<V> values = this.relations.get(key);
		if (values == null) {
			values = new LinkedList<>();		}
		values.add(value);
		this.relations.put(key, values);
	}

	@Override
	public void deleteRelation(Relations key, V value) {
		List<V> values = this.relations.get(key);
		values.remove(value);
		this.relations.put(key, values);
	}

	@Override
	public List<V> getRelation(Relations key) {
		return this.relations.get(key);
	}
}
