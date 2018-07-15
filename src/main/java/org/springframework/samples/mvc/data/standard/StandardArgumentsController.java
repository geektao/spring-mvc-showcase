package org.springframework.samples.mvc.data.standard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StandardArgumentsController {

	// request related

	@RequestMapping(method = RequestMethod.GET, value = "/data/standard/request")
	public @ResponseBody String standardRequestArgs(HttpServletRequest request, Principal user, Locale locale) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("request = ").append(request).append(", ");
		buffer.append("userPrincipal = ").append(user).append(", ");
		buffer.append("requestLocale = ").append(locale);
		return buffer.toString();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/data/standard/request/reader")
	public @ResponseBody String requestReader(Reader requestBodyReader) throws IOException {
		return "Read char request body = " + FileCopyUtils.copyToString(requestBodyReader);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/data/standard/request/is")
	public @ResponseBody String requestReader(InputStream requestBodyIs) throws IOException {
		return "Read binary request body = " + new String(FileCopyUtils.copyToByteArray(requestBodyIs));
	}

	// response related

	@RequestMapping(method = RequestMethod.GET, value = "/data/standard/response")
	public @ResponseBody String response(HttpServletResponse response) {
		return "response = " + response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/data/standard/response/writer")
	public @ResponseBody void availableStandardResponseArguments(Writer responseWriter) throws IOException {
		responseWriter.write("Wrote char response using Writer");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/data/standard/response/os")
	public @ResponseBody void availableStandardResponseArguments(OutputStream os) throws IOException {
		os.write("Wrote binary response using OutputStream".getBytes());
	}

	// HttpSession

	@RequestMapping(method = RequestMethod.GET, value = "/data/standard/session")
	public @ResponseBody String session(HttpSession session) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("session=").append(session);
		return buffer.toString();
	}

}
