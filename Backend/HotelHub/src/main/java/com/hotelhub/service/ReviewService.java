package com.hotelhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelhub.dao.HotelDao;
import com.hotelhub.dao.ReviewDao;
import com.hotelhub.dao.UserDao;
import com.hotelhub.dto.ReviewDTO;
import com.hotelhub.entity.Hotel;
import com.hotelhub.entity.Review;
import com.hotelhub.entity.User;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewDao reviewRepository;
    
    @Autowired
    private UserDao userRepository;
    
    @Autowired
    private HotelDao hotelRepository;

    // Method to add a review
    public Review addReview(ReviewDTO reviewDTO) {
        User user = userRepository.findById(reviewDTO.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));

        Hotel hotel = hotelRepository.findById(reviewDTO.getHotelId())
            .orElseThrow(() -> new RuntimeException("Hotel not found"));
        
        Review review = new Review();
        review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating());
        review.setUser(user);
        review.setHotel(hotel);

        return reviewRepository.save(review);
    }

    // Other methods if needed
}

