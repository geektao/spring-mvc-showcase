package org.springframework.samples.mvc.convert;

import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/convert")
public class ConvertController {

	@RequestMapping(method = RequestMethod.GET,value="primitive")
	public String primitive(@RequestParam Integer value) {
		return "Converted primitive " + value;
	}

	// requires Joda-Time on the classpath
	@RequestMapping(method = RequestMethod.GET,value="date/{value}")
	public String date(@PathVariable @DateTimeFormat(iso=ISO.DATE) Date value) {
		return "Converted date " + value;
	}

	@RequestMapping(method = RequestMethod.GET,value="collection")
	public String collection(@RequestParam Collection<Integer> values) {
		return "Converted collection " + values;
	}

	@RequestMapping(method = RequestMethod.GET,value="formattedCollection")
	public String formattedCollection(@RequestParam @DateTimeFormat(iso=ISO.DATE) Collection<Date> values) {
		return "Converted formatted collection " + values;
	}

	@RequestMapping(method = RequestMethod.GET,value="bean")
	public String bean(JavaBean bean) {
		return "Converted " + bean;
	}

	@RequestMapping(method = RequestMethod.GET,value="value")
	public String valueObject(@RequestParam SocialSecurityNumber value) {
		return "Converted value object " + value;
	}

	@RequestMapping(method = RequestMethod.GET,value="custom")
	public String customConverter(@RequestParam @MaskFormat("###-##-####") String value) {
		return "Converted '" + value + "' with a custom converter";
	}

}
