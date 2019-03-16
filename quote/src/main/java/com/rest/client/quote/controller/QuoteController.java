package com.rest.client.quote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.rest.client.quote.model.Quote;

@RestController
@RequestMapping("/quotes")
public class QuoteController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/all")
	public List<Quote> getAllQuotes() {
		//RestTemplate restTemplate = new RestTemplate();
		//InstanceInfo info = 
		List<Quote> forObject = restTemplate.getForObject("http://QUOTE-SERVICE/rest/db/all", List.class);
		return forObject;
	}

	

}
