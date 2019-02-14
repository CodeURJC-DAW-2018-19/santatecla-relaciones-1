package es.santatecla.interfaces;

import es.santatecla.enums.Relations;

public interface IRelation<V> {
	void addRelation(Relations key, V value);
	
	void deleteRelation(Relations key, V value);
}
