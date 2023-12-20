package com.sound.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sound.mall.model.dto.Wishlist;
import com.sound.mall.model.service.WishlistService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-wishlist")
public class WishlistController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	private static final String EXIST = "already exist";
	
	@Autowired
	private WishlistService wishService;
	
	@GetMapping("getwish")
	public ResponseEntity<String> getwish(Wishlist wish){
		if(wishService.getWishlist(wish)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK); // 200 OK
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST); // 400 Bad Request
		
	}
	
	@PostMapping("addwish")
	@ApiOperation(value = "찜등록 성공여부(boolean)에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	public ResponseEntity<String> addWish(Wishlist wish){
		Wishlist tmp = wish;
		//기존에 이미 찜이 존재하면 중복생성 되는 것을 방지
		if(wishService.getWishlist(tmp)) {
			return new ResponseEntity<String>(EXIST, HttpStatus.OK); // 200 OK
		}else if(wishService.addWishlist(tmp)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK); // 200 OK
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST); // 400 Bad Request
	}
	@DeleteMapping("deletewish")
	@ApiOperation(value = "찜삭 성공여부(boolean)에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	public ResponseEntity<String> deleteWish(Wishlist wish){
		if(wishService.deleteWishlist(wish)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK); // 200 OK
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST); // 400 Bad Request
	}
}
