package org.springframework.samples.mvc.validation;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ValidationController {

	// enforcement of constraints on the JavaBean arg require a JSR-303 provider on the classpath
	
	@RequestMapping(method = RequestMethod.GET,value="/validate")
	public String validate(@Valid JavaBean bean, BindingResult result) {
		if (result.hasErrors()) {
			return "Object has validation errors";
		} else {
			return "No errors";
		}
	}

}
