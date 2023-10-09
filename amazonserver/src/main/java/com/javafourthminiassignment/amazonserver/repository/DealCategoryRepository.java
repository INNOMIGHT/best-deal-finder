package com.javafourthminiassignment.amazonserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafourthminiassignment.amazonserver.entity.DealCategory;

@Repository
public interface DealCategoryRepository extends JpaRepository<DealCategory, String> {
}

