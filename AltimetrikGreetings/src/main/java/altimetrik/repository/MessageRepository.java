package altimetrik.repository;

import org.springframework.data.repository.CrudRepository;

import altimetrik.greetings.domain.Message;

public interface MessageRepository  extends CrudRepository<Message,String>{

}
