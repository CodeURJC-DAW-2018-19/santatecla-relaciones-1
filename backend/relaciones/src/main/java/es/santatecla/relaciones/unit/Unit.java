package es.santatecla.relaciones.unit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Unit {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private String id;

}
