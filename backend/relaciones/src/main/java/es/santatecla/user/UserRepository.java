package es.santatecla.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User getById(long id);
	User findByName(String name);

}
