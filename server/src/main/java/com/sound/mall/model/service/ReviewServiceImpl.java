package com.sound.mall.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.mall.model.dao.ReviewDao;
import com.sound.mall.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDao reviewDao;
	
	//리뷰 등록
	@Override
	public boolean addReview(Review review) {
		return reviewDao.createReview(review) > 0;
	}
	//리뷰 개인별조회
	@Override
	public Review selectReview(String userId, int itemId) {
		System.out.println("userId: "+userId);
		System.out.println("itemId: "+itemId);
		return reviewDao.selectReview(userId, itemId);
	}
	//리뷰 전체조회
	@Override
	public List<Review> getAllReview(int itemId) {
		return reviewDao.selectAllReview(itemId);
	}
	//리뷰 수정
	@Override
	public boolean updateReview(Review review) {
		return reviewDao.updateReview(review) > 0;
	}
	//리뷰 삭제
	@Override
	public boolean deleteReview(String userId, int itemId) {
		return reviewDao.deleteReveiw(userId, itemId) > 0;
	}

}
