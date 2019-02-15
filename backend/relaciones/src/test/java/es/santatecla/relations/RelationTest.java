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
	private String Parent1 = "Parent1";
	private String Parent2 = "Parent2";
	private String Parent3 = "Parent3";
	private String Parent4 = "Parent4";
	private String Parent5 = "Parent5";
	private String Parent6 = "Parent6";
	private String Parent7 = "Parent7";
	
	@Test
	public void addRElationTest() {
		this.relation.addRelation(Relations.PARENT, Parent1);
		this.relation.addRelation(Relations.PARENT, Parent2);
		this.relation.addRelation(Relations.PARENT, Parent3);
		this.relation.addRelation(Relations.PARENT, Parent5);
		this.relation.addRelation(Relations.PARENT, Parent6);
		this.relation.addRelation(Relations.PARENT, Parent7);		
		
		assertEquals(this.relation.getRelation(Relations.PARENT).contains(Parent1), true);
		assertEquals(this.relation.getRelation(Relations.PARENT).contains(Parent4), false);
	}
	
	@Test
	public void deleteRelationTest() {
		this.relation.addRelation(Relations.PARENT, Parent1);
		this.relation.addRelation(Relations.PARENT, Parent2);
		this.relation.addRelation(Relations.PARENT, Parent3);
		this.relation.addRelation(Relations.PARENT, Parent5);
		this.relation.addRelation(Relations.PARENT, Parent6);
		this.relation.addRelation(Relations.PARENT, Parent7);
		
		this.relation.deleteRelation(Relations.PARENT, Parent1);
		
		assertEquals(this.relation.getRelation(Relations.PARENT).contains(Parent1), false);
		
		this.relation.deleteRelation(Relations.PARENT, Parent2);
		this.relation.deleteRelation(Relations.PARENT, Parent3);
		this.relation.deleteRelation(Relations.PARENT, Parent5);
		this.relation.deleteRelation(Relations.PARENT, Parent6);
		this.relation.deleteRelation(Relations.PARENT, Parent7);
		
		assertEquals(this.relation.getRelation(Relations.PARENT).isEmpty(), true);
	}
	
	@Test
	public void getRelationTest() {
		this.relation.addRelation(Relations.PARENT, Parent1);
		this.relation.addRelation(Relations.PARENT, Parent2);
		this.relation.addRelation(Relations.PARENT, Parent3);
		this.relation.addRelation(Relations.PARENT, Parent5);
		this.relation.addRelation(Relations.PARENT, Parent6);
		this.relation.addRelation(Relations.PARENT, Parent7);
		
		List<String> relations = this.relation.getRelation(Relations.PARENT);
		
		assertEquals(relations.contains(Parent1), true);
		assertEquals(relations.contains(Parent4), false);
		
		relations = this.relation.getRelation(Relations.CHILD);
		
		assertEquals(relations.isEmpty(), true);
	}
}
