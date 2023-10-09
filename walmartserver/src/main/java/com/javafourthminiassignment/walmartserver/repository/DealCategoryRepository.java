package com.javafourthminiassignment.walmartserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafourthminiassignment.walmartserver.entity.DealCategory;

@Repository
public interface DealCategoryRepository extends JpaRepository<DealCategory, String> {
}

