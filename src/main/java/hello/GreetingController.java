package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

	private SimpMessagingTemplate template;

	public GreetingController(SimpMessagingTemplate template) {
		this.template = template;
	}

	@MessageMapping("/hello")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(2000); // simulated delay
		greetings(message);
		return new Greeting("HelloMe, " + HtmlUtils.htmlEscape(message.getFlight()) + "!");
	}

	public String greetings(HelloMessage message) throws Exception {
		this.template.convertAndSend("/topic/greetings/" + message.getSession(), new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getFlight()) + "!"));
		return "helloMeToo";
	}

}
