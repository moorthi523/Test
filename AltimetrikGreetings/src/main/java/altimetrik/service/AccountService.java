package altimetrik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import altimetrik.greetings.domain.User;
import altimetrik.repository.UserRepository;

@Service
public class AccountService {
	
	@Autowired
	UserRepository repository;

	public void signUp(User user) {
		
		
		//JWT token assigned to each user
		user.setToken("JWT token ");
		repository.save(user);
	}
	
	public User findUser(String username) {
		return repository.findByUsername(username);	
	}
	
}
