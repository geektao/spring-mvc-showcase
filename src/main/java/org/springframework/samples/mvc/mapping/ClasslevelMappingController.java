package org.springframework.samples.mvc.mapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/class-mapping/*")
public class ClasslevelMappingController {

	@RequestMapping(method = RequestMethod.GET,value="/path")
	public String byPath() {
		return "Mapped by path!";
	}

	@RequestMapping(method = RequestMethod.GET,value="/path/*")
	public String byPathPattern(HttpServletRequest request) {
		return "Mapped by path pattern ('" + request.getRequestURI() + "')";
	}

	@RequestMapping(method = RequestMethod.GET,value="/method")
	public String byMethod() {
		return "Mapped by path + method";
	}

	@RequestMapping(method = RequestMethod.GET,value="/parameter", params="foo")
	public String byParameter() {
		return "Mapped by path + method + presence of query parameter!";
	}

	@RequestMapping(method = RequestMethod.GET,value="/parameter", params="!foo")
	public String byParameterNegation() {
		return "Mapped by path + method + not presence of query!";
	}

	@RequestMapping(method = RequestMethod.GET,value="/header", headers="FooHeader=foo")
	public String byHeader() {
		return "Mapped by path + method + presence of header!";
	}

	@RequestMapping(method = RequestMethod.GET,value="/notheader", headers="!FooHeader")
	public String byHeaderNegation() {
		return "Mapped by path + method + absence of header!";
	}


	@RequestMapping(method = RequestMethod.POST,value="/consumes", consumes="application/json")
	public String byConsumes(@RequestBody JavaBean javaBean) {
		return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
	}

	@RequestMapping(method = RequestMethod.GET,value="/produces", produces="application/json")
	public JavaBean byProduces() {
		return new JavaBean();
	}

}
