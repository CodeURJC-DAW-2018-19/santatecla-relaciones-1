package es.santatecla.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User getById(long id);
	User findByName(String name);
	

}
