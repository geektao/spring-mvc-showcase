package org.springframework.samples.mvc.mapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MappingController {

	@RequestMapping(method = RequestMethod.GET, value = "/mapping/path")
	public String byPath() {
		return "Mapped by path!";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mapping/path/*")
	public String byPathPattern(HttpServletRequest request) {
		return "Mapped by path pattern ('" + request.getRequestURI() + "')";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mapping/method")
	public String byMethod() {
		return "Mapped by path + method";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mapping/parameter", params = "foo")
	public String byParameter() {
		return "Mapped by path + method + presence of query parameter!";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mapping/parameter", params = "!foo")
	public String byParameterNegation() {
		return "Mapped by path + method + not presence of query parameter!";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mapping/header", headers = "FooHeader=foo")
	public String byHeader() {
		return "Mapped by path + method + presence of header!";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mapping/header", headers = "!FooHeader")
	public String byHeaderNegation() {
		return "Mapped by path + method + absence of header!";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/mapping/consumes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String byConsumes(@RequestBody JavaBean javaBean) {
		return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mapping/produces", produces = MediaType.APPLICATION_JSON_VALUE)
	public JavaBean byProducesJson() {
		return new JavaBean();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mapping/produces", produces = MediaType.APPLICATION_XML_VALUE)
	public JavaBean byProducesXml() {
		return new JavaBean();
	}

}
