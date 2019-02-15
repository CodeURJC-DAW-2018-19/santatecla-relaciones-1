package es.santatecla.database.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ContextDaughter
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}
