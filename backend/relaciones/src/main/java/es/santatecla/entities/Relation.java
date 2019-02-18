package es.santatecla.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Relation<K, V> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private K key;
	
	private V value;
}
