package altimetrik.messaging;


import org.apache.kafka.clients.producer.Producer;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class GreetingProducer {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final String TOPIC = "greetings";
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	public void sendMessage(String message){
	logger.info(String.format("$$ -> Producing message --> %s",message));
	this.kafkaTemplate.send(TOPIC,message);
	}
}
