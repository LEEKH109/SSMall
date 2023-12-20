package com.sound.mall.model.service;

import java.util.List;

import com.sound.mall.model.dto.Review;

public interface ReviewService {
	// interface 내부에서는 명시적으로 전부 public이므로 생략
	
	//리뷰 등록
	boolean addReview(Review review);
	//리뷰 개인별조회
	Review selectReview(String userId, int itemId);
	//리뷰 전체조회
	List<Review> getAllReview(int itemId);
	//리뷰 수정
	boolean updateReview(Review review);
	//리뷰 삭제
	boolean deleteReview(String userId, int itemId);
}
