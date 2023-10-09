package com.javafourthminiassignment.ebayserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafourthminiassignment.ebayserver.entity.DealCategory;
import com.javafourthminiassignment.ebayserver.entity.DealItem;
import com.javafourthminiassignment.ebayserver.repository.DealCategoryRepository;
import com.javafourthminiassignment.ebayserver.repository.DealItemRepository;


@RestController
@RequestMapping
public class DealController {
	
	@Autowired
	DealItemRepository dealItemRepository;
	
	@Autowired
	DealCategoryRepository dealCategoryRepository;
	
	
	 @GetMapping("/backendserver2/dealItems/{categoryName}")
	    public List<DealItem> getItemsByCategory(@PathVariable String categoryName) {
	        return dealItemRepository.findByDealCategoryCategory(categoryName);
	    }
	 
	 @GetMapping("/backendserver2/ebay/deals/{categoryName}")
	    public DealCategory getCategory(@PathVariable String categoryName) {
	        return dealCategoryRepository.findById(categoryName).get();
	    }

}
