package org.springframework.samples.mvc.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionController {

	@RequestMapping(method = RequestMethod.GET,value="/exception")
	public String exception() {
		throw new IllegalStateException("Sorry!");
	}

	@RequestMapping(method = RequestMethod.GET, value ="/global-exception")
	public String businessException() throws BusinessException {
		throw new BusinessException();
	}

	@ExceptionHandler
	public String handle(IllegalStateException e) {
		return "IllegalStateException handled!";
	}

}
