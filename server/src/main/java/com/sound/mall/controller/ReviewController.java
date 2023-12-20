package com.sound.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sound.mall.model.dto.Review;
import com.sound.mall.model.service.ReviewService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-review")
public class ReviewController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping("review-regist")
	@ApiOperation(value = "리뷰 생성,DB입력 성공여부(boolean)에 따라 'success' 또는 'fail' 문자열을 반환", response = String.class)
	public ResponseEntity<String> registReview(Review review){
		if(reviewService.addReview(review)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK); // 200 OK
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST); // 400 Bad Request
	}
	
	@GetMapping("review/{itemId}")
	@ApiOperation(value = "유저 아이디 기준으로 리뷰 조회, 성공시 해당 리뷰 반환, 실패시 FAIL 문자열을 반환", response = Review.class)
	public ResponseEntity<?> getReview(@RequestParam String userId, @PathVariable int itemId){
		System.out.println("userId: "+userId);
		System.out.println("itemId: "+itemId);
		Review selectedReview = reviewService.selectReview(userId, itemId);
		if(selectedReview != null) {
			return new ResponseEntity<Review>(selectedReview, HttpStatus.OK); // 200 OK
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND); // 404 Not Found
	}
	
	@GetMapping("review-all/{itemId}")
	@ApiOperation(value = "해당 품목의 전체 리뷰 조회, 성공시 리뷰 리스트 반환, 실패시 FAIL 문자열을 반환", response = List.class)
	public ResponseEntity<?> getAllReview(@PathVariable int itemId){
		List<Review> reviewList = reviewService.getAllReview(itemId);
		if(reviewList == null || reviewList.size() == 0) { 
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT); // 204 No Content
		}
		return new ResponseEntity<List<Review>>(reviewList, HttpStatus.OK); // 200 OK
	}
	
	@PostMapping("review-update")
	@ApiOperation(value = "유저 아이디 기준으로 리뷰 조회 후 업데이트, 성공시 SUCCESS, 실패시 FAIL 문자열을 반환", response = String.class)
	public ResponseEntity<String> updateReview(Review review){
		if(reviewService.updateReview(review)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK); // 200 OK
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST); // 400 Bad Request
	}
	
	@DeleteMapping("review/{itemId}")
	@ApiOperation(value = "유저 아이디 기준으로 리뷰 조회 후 삭제, 성공시 SUCCESS, 실패시 FAIL 문자열을 반환", response = String.class)
	public ResponseEntity<String> deleteReview(String userId, @PathVariable int itemId){
		if(reviewService.deleteReview(userId, itemId)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK); // 200 OK
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST); // 400 Bad Request
	}
	
}
