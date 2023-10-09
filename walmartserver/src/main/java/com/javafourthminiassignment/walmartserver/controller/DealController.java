package com.javafourthminiassignment.walmartserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafourthminiassignment.walmartserver.entity.DealCategory;
import com.javafourthminiassignment.walmartserver.entity.DealItem;
import com.javafourthminiassignment.walmartserver.repository.DealCategoryRepository;
import com.javafourthminiassignment.walmartserver.repository.DealItemRepository;


@RestController
@RequestMapping
public class DealController {
	

	
	@Autowired
	DealItemRepository dealItemRepository;
	
	@Autowired
	DealCategoryRepository dealCategoryRepository;
	
	 @GetMapping("/backendserver3/dealItems/{categoryName}")
	    public List<DealItem> getItemsByCategory(@PathVariable String categoryName) {
	        return dealItemRepository.findByDealCategoryCategory(categoryName);
	    }
	 
	 @GetMapping("/backendserver3/walmart/deals/{categoryName}")
	    public DealCategory getCategory(@PathVariable String categoryName) {
	        return dealCategoryRepository.findById(categoryName).get();
	    }

}
