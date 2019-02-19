package es.santatecla.relaciones.tool;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import es.santatecla.relaciones.unit.Unit;
import es.santatecla.relaciones.user.User;

@Entity
public class Tool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	private Unit unit;
	
	private User user;
	

}
