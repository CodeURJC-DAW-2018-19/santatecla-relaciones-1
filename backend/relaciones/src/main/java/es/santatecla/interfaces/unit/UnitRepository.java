package es.santatecla.interfaces.unit;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santatecla.entities.unit.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long>{

}
