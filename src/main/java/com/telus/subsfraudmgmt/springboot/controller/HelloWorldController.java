package com.telus.subsfraudmgmt.springboot.controller;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.model.Greeting;
import com.telus.subsfraudmgmt.springboot.service.ConfigService;
import com.telus.subsfraudmgmt.springboot.service.GreetingService;
import com.telus.subsfraudmgmt.springboot.service.PingService;

import org.apache.commons.logging.Log;



@RestController
public class HelloWorldController {

	private final Log log = CustomizedLogFactory.getLog( HelloWorldController.class );

	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private PingService pingService;

	@Autowired
	private GreetingService greetingSvc;

	@Autowired
	private ConfigService configService;

	public AtomicLong getCounter() {
		return counter;
	}

	@RequestMapping(value= {"/ping"}, 		 
			produces = {"application/json" }		 
	)
	public String pingTest() {
		log.info("ping:received!");
		String message= pingService.getPingMessage();
		log.info("ping:message constructed!");
		return message;

	}
	@RequestMapping(value= {"/greeting"}, 		 
			produces = {"application/json" }		 
	)
	public String greeting() {
		String message= "hello";
		return message;

	}
	@RequestMapping(value={"/greeting","/greeting2","/greeting3" })
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(), greetingSvc.getGreetingMessage(name));
	}


	@RequestMapping(value={"/config"})
	public String config(@RequestParam(value="html", defaultValue="false") boolean htmlFormat) {
		return configService.outputConfig(htmlFormat);
	}

	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Principal principal) {
		if (principal==null) {
			return "anonymous";
		}
		return principal.getName();
	}

}
