package com.hotelhub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelhub.entity.Review;

@Repository
public interface ReviewDao extends JpaRepository<Review, Long> {
    // Custom query methods if needed
}

