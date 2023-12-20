package com.sound.mall.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sound.mall.model.dto.Review;

public interface ReviewDao {
	//리뷰 등록
	int createReview(Review review);
	//리뷰 건별 조회
	Review selectReview(@Param("userId") String userId, @Param("itemId") int itemId);
	//리뷰 전체 조회
	List<Review> selectAllReview(int itemId);
	//리뷰 수정
	int updateReview(Review review);
	//리뷰 삭제
	int deleteReveiw(String userId, int itemId);
}
