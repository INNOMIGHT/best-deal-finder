package com.javafourthminiassignment.walmartserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafourthminiassignment.walmartserver.entity.DealItem;

@Repository
public interface DealItemRepository extends JpaRepository<DealItem, Long> {
	
	List<DealItem> findByDealCategoryCategory(String categoryName);
}