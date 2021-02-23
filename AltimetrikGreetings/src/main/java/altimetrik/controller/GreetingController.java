package altimetrik.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import altimetrik.greetings.domain.Message;
import altimetrik.messaging.GreetingProducer;
import altimetrik.repository.MessageRepository;

@RestController
@RequestMapping("api/greeting")
public class GreetingController {

	@Autowired
	GreetingProducer greetingProducer;

	@Autowired
	MessageRepository msgRepo;

	@RequestMapping(method = RequestMethod.POST, path = "/send")
	public void sendGreetings(@RequestParam("mobiles") String mobiles, @RequestHeader("token") String token) {
		List<String> mobileNums = Stream.of(mobiles.split(",")).collect(Collectors.toList());
		Message msg = null;
		for (String mob : mobileNums) {
			msg = new Message();
			msg.setMobile(mob);
			msg.setMsg("Happy new Year");
			msg.setStatus("Success");
			msgRepo.save(msg);
			greetingProducer.sendMessage("Happy new Year");

		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/hi")
	public String sayHi() {

		return "new application hello";
	}

}
