package es.santatecla.entities.relation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import es.santatecla.enums.RelationsEnum;

@Entity
public class Relation<V> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private RelationsEnum key;
	
	private V value;
}
