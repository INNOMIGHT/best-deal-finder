package com.javafourthminiassignment.amazonserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafourthminiassignment.amazonserver.entity.DealCategory;
import com.javafourthminiassignment.amazonserver.entity.DealItem;
import com.javafourthminiassignment.amazonserver.repository.DealCategoryRepository;
import com.javafourthminiassignment.amazonserver.repository.DealItemRepository;
import com.javafourthminiassignment.amazonserver.service.DealService;

@RestController
@RequestMapping
public class DealController {
	
	@Autowired
	DealService dealService;
	
	@Autowired
	DealItemRepository dealItemRepository;
	
	@Autowired
	DealCategoryRepository dealCategoryRepository;
	
	@PostMapping("/add_product")
	public DealCategory addProduct() {
		DealCategory deal = dealService.insertData();
		return deal;
	}
	
	 @GetMapping("/backendserver1/dealItems/{categoryName}")
	    public List<DealItem> getItemsByCategory(@PathVariable String categoryName) {
	        return dealItemRepository.findByDealCategoryCategory(categoryName);
	    }
	 
	 @GetMapping("/backendserver1/amazon/deals/{categoryName}")
	    public DealCategory getCategory(@PathVariable String categoryName) {
	        return dealCategoryRepository.findById(categoryName).get();
	    }

}
