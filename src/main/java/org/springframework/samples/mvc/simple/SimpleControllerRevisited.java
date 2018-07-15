package org.springframework.samples.mvc.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleControllerRevisited {

	@RequestMapping(method = RequestMethod.GET,value="/simple/revisited", headers="Accept=text/plain")
	public String simple() {
		return "Hello world revisited!";
	}

}
