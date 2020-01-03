package altimetrik.repository;

import org.springframework.data.repository.CrudRepository;

import altimetrik.greetings.domain.User;

public interface UserRepository extends CrudRepository<User, String>{

	public User findByUsername(String username);
	
}
