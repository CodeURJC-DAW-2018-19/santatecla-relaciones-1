package es.santatecla.relations;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import es.santatecla.interfaces.IRelation;
import es.santatecla.enums.*;

public class RelationTest {
	private Map<Relations, List<String>> relations = new HashMap<>();
	private IRelation<String> relation = new Relation<>(relations);
	
	@Test
	public void addRElationTest() {
		String Parent1 = "Parent1";
		
		this.relation.addRelation(Relations.PARENT, Parent1);
		
		assertEquals(this.relation.getRelation(Relations.PARENT).contains(Parent1), true);
	}
}
