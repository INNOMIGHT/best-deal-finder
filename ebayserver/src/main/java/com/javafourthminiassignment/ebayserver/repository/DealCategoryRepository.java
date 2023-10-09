package com.javafourthminiassignment.ebayserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafourthminiassignment.ebayserver.entity.DealCategory;

@Repository
public interface DealCategoryRepository extends JpaRepository<DealCategory, String> {
}

