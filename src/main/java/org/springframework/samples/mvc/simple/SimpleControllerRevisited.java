package org.springframework.samples.mvc.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleControllerRevisited {

	@RequestMapping(method = RequestMethod.GET, value = "/simple/revisited", headers = "Accept=text/plain")
	public @ResponseBody String simple() {
		return "Hello world revisited!";
	}

}
