package com.javafourthminiassignment.amazonserver.service;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.javafourthminiassignment.amazonserver.dto.DiscountAmount;
import com.javafourthminiassignment.amazonserver.dto.Image;
import com.javafourthminiassignment.amazonserver.dto.MarketingPriceDTO;
import com.javafourthminiassignment.amazonserver.dto.OriginalPrice;
import com.javafourthminiassignment.amazonserver.dto.PriceDTO;
import com.javafourthminiassignment.amazonserver.entity.DealCategory;
import com.javafourthminiassignment.amazonserver.entity.DealItem;
import com.javafourthminiassignment.amazonserver.repository.DealCategoryRepository;
import com.javafourthminiassignment.amazonserver.repository.DealItemRepository;

@Service
public class DealService {
    private final DealCategoryRepository dealCategoryRepository;
    private final DealItemRepository dealItemRepository;

    @Autowired
    public DealService(DealCategoryRepository dealCategoryRepository, DealItemRepository dealItemRepository) {
        this.dealCategoryRepository = dealCategoryRepository;
        this.dealItemRepository = dealItemRepository;
    }

    public DealCategory insertData() {
        // Create an instance of DealCategory
    	
        DealCategory dealCategory = dealCategoryRepository.findById("Jeans").get();
        if(dealCategory != null) {
        	// Create an instance of DealItem
            DealItem dealItem = new DealItem();

            dealItem.setProductTitle("Black Levis Jeans");
            dealItem.setSize("32");
            dealItem.setBrand("Levis");

            // Create an instance of Image and set its properties
            Image image = new Image();
            image.setImageUrl("https://i.ebayimg.com/images/g/~**********N/s-l225.jpg");
            dealItem.setImageObject(image);

            // Create an instance of MarketingPriceDTO and set its properties
            MarketingPriceDTO marketingPriceDTO = new MarketingPriceDTO();

            OriginalPrice originalPrice = new OriginalPrice();
            originalPrice.setValue("29.99");
            originalPrice.setCurrency("USD");
            marketingPriceDTO.setOriginalPrice(originalPrice);

            marketingPriceDTO.setDiscountPercentage("60");

            DiscountAmount discountAmount = new DiscountAmount();
            discountAmount.setValue("18");
            discountAmount.setCurrency("USD");
            marketingPriceDTO.setDiscountAmount(discountAmount);

            marketingPriceDTO.setPriceTreatment("LIST_PRICE");
            dealItem.setMarketingPriceObject(marketingPriceDTO);

            // Create an instance of PriceDTO and set its properties
            PriceDTO priceDTO = new PriceDTO();
            priceDTO.setValue("12.99");
            priceDTO.setCurrency("USD");
            dealItem.setPriceObject(priceDTO);

            dealItem.setStock(3);
            dealItem.setDealStartDate(Date.from(Instant.parse("2022-06-20T15:26:00Z")));
            dealItem.setDealEndDate(Date.from(Instant.parse("2024-12-20T14:59:59Z")));

            // Set the relationship between DealCategory and DealItem
            dealItem.setDealCategory(dealCategory);
            dealCategory.setDealItems(Collections.singletonList(dealItem));

            // Save the data to the database
            dealItemRepository.save(dealItem);
            return dealCategory;
        }
		return dealCategory;
        
        
        
    }
    
   
}

