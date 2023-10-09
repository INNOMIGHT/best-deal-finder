package com.javafourthminiassignment.bestpricefinder.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.javafourthminiassignment.bestpricefinder.entity.DealCategory;
import com.javafourthminiassignment.bestpricefinder.entity.DealItem;

import reactor.core.publisher.Mono;

@Service
public class DealService {

	private final WebClient amazonWebClient;
	private final WebClient ebayWebClient;
	private final WebClient walmartWebClient;


	@Autowired
	public DealService(@Qualifier("amazonWebClient") WebClient amazonWebClient, @Qualifier("ebayWebClient") WebClient ebayWebClient, @Qualifier("walmartWebClient") WebClient walmartWebClient) {
		super();
		this.amazonWebClient = amazonWebClient;
		this.ebayWebClient = ebayWebClient;
		this.walmartWebClient = walmartWebClient;
		
	}

	private final ExecutorService executorService = Executors.newFixedThreadPool(3);
	
	public CompletableFuture<List<DealItem>> getAmazonDeals(String category){
		return CompletableFuture.supplyAsync(() -> {
            return amazonWebClient.get()
                    .uri("/{category}", category) // Replace with the specific API endpoint
                    .retrieve()
                    .bodyToFlux(DealItem.class) // Deserialize the response into a Flux of DealItem
                    .collectList()
                    .block(); // Block and get the response as a List<DealItem>
        });
        
	}
	
	public CompletableFuture<List<DealItem>> getEbayDeals(String category){
		return CompletableFuture.supplyAsync(() -> {
            return ebayWebClient.get()
                    .uri("/{category}", category) // Replace with the specific API endpoint
                    .retrieve()
                    .bodyToFlux(DealItem.class) // Deserialize the response into a Flux of DealItem
                    .collectList()
                    .block(); // Block and get the response as a List<DealItem>
        });
        
	}
	
	public CompletableFuture<List<DealItem>> getWalmartDeals(String category){
		return CompletableFuture.supplyAsync(() -> {
            return walmartWebClient.get()
                    .uri("/{category}", category) // Replace with the specific API endpoint
                    .retrieve()
                    .bodyToFlux(DealItem.class) // Deserialize the response into a Flux of DealItem
                    .collectList()
                    .block(); // Block and get the response as a List<DealItem>
        });
        
	}
	
	public DealCategory getBestDeals(String category) {
		
		CompletableFuture<List<DealItem>> amazonFuture = getAmazonDeals(category);
	    CompletableFuture<List<DealItem>> ebayFuture = getEbayDeals(category);
	    CompletableFuture<List<DealItem>> walmartFuture = getWalmartDeals(category);

	    CompletableFuture<Void> allOf = CompletableFuture.allOf(amazonFuture, ebayFuture, walmartFuture);

	    allOf.join(); // Wait for all API calls to complete concurrently

	    List<DealItem> amazonDeals = amazonFuture.join();
	    List<DealItem> ebayDeals = ebayFuture.join();
	    List<DealItem> walmartDeals = walmartFuture.join();

	    List<DealItem> mergedDealsList = Stream.of(amazonDeals, ebayDeals, walmartDeals)
	            .flatMap(Collection::stream)
	            .collect(Collectors.toList());

	    DealCategory bestDeals = new DealCategory();
	    bestDeals.setCategory(category);
	    List<DealItem> finalDealsList = processDeals(mergedDealsList);
	    bestDeals.setDealItems(finalDealsList);

	    return bestDeals;
		
	}
	
	public List<DealItem> processDeals(List<DealItem> deals) {
        Date currentDate = new Date(); // Get the current date

        List<DealItem> filteredAndSortedDeals = deals.stream()
                .filter(DealItem.class::isInstance) // Filter out non-DealItem objects
                .map(DealItem.class::cast) // Cast to DealItem
                .filter(deal -> deal.getStock() > 0) // Filter out items with zero stock
                .filter(deal -> currentDate.after(deal.getDealStartDate()) && currentDate.before(deal.getDealEndDate())) // Filter based on deal date
                .sorted(Comparator.<DealItem, Float>comparing(deal -> Float.parseFloat(deal.getMarketingPriceObject().getDiscountPercentage()))
                        .reversed()
                        .thenComparing(deal -> deal.getPriceObject().getValue())) // Sort by maximum discount first (as float), then by lowest price
                .collect(Collectors.toList());

        return filteredAndSortedDeals;
    }
	
}
