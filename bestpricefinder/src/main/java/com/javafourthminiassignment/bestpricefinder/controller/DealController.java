package com.javafourthminiassignment.bestpricefinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javafourthminiassignment.bestpricefinder.service.DealService;

@RestController
@RequestMapping
public class DealController {
	
	@Autowired
	DealService dealService;
	
	@GetMapping("/deals/{category}")
	public Object getBestDeals(@PathVariable String category) {
		return dealService.getBestDeals(category);
	}
	
	
}
