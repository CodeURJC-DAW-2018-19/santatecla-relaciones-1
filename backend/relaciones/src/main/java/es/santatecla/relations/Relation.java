package es.santatecla.relations;

import java.util.Dictionary;
import java.util.List;

import es.santatecla.enums.Relations;
import es.santatecla.interfaces.IRelation;

public class Relation implements IRelation {
	
	private Dictionary<Relations, List<String>> relations;

	public Relation (Dictionary<Relations, List<String>> relations) {
		this.relations = relations;
	}
	
	
}
