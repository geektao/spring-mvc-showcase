package org.springframework.samples.mvc.messageconverters;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rometools.rome.feed.atom.Feed;
import com.rometools.rome.feed.rss.Channel;

@Controller
@RequestMapping("/messageconverters")
public class MessageConvertersController {

	// StringHttpMessageConverter

	@RequestMapping(method = RequestMethod.POST, value = "/string")
	public @ResponseBody String readString(@RequestBody String string) {
		return "Read string '" + string + "'";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/string")
	public @ResponseBody String writeString() {
		return "Wrote a string";
	}

	// Form encoded data (application/x-www-form-urlencoded)

	@RequestMapping(method = RequestMethod.POST, value = "/form")
	public @ResponseBody String readForm(@ModelAttribute JavaBean bean) {
		return "Read x-www-form-urlencoded: " + bean;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/form")
	public @ResponseBody MultiValueMap<String, String> writeForm() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("foo", "bar");
		map.add("fruit", "apple");
		return map;
	}

	// Jaxb2RootElementHttpMessageConverter (requires JAXB2 on the classpath -
	// useful for serving clients that expect to work with XML)

	@RequestMapping(method = RequestMethod.POST, value = "/xml")
	public @ResponseBody String readXml(@RequestBody JavaBean bean) {
		return "Read from XML: " + bean;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/xml")
	public @ResponseBody JavaBean writeXml() {
		return new JavaBean("bar", "apple");
	}

	// MappingJacksonHttpMessageConverter (requires Jackson on the classpath -
	// particularly useful for serving JavaScript clients that expect to work with
	// JSON)

	@RequestMapping(method = RequestMethod.POST, value = "/json")
	public @ResponseBody String readJson(@Valid @RequestBody JavaBean bean) {
		return "Read from JSON: " + bean;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/json")
	public @ResponseBody JavaBean writeJson() {
		return new JavaBean("bar", "apple");
	}

	// AtomFeedHttpMessageConverter (requires Rome on the classpath - useful for
	// serving Atom feeds)

	@RequestMapping(method = RequestMethod.POST, value = "/atom")
	public @ResponseBody String readFeed(@RequestBody Feed feed) {
		return "Read " + feed.getTitle();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/atom")
	public @ResponseBody Feed writeFeed() {
		Feed feed = new Feed();
		feed.setFeedType("atom_1.0");
		feed.setTitle("My Atom feed");
		return feed;
	}

	// RssChannelHttpMessageConverter (requires Rome on the classpath - useful for
	// serving RSS feeds)

	@RequestMapping(method = RequestMethod.POST, value = "/rss")
	public @ResponseBody String readChannel(@RequestBody Channel channel) {
		return "Read " + channel.getTitle();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/rss")
	public @ResponseBody Channel writeChannel() {
		Channel channel = new Channel();
		channel.setFeedType("rss_2.0");
		channel.setTitle("My RSS feed");
		channel.setDescription("Description");
		channel.setLink("http://localhost:8080/mvc-showcase/rss");
		return channel;
	}

}