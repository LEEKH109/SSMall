package com.sound.mall.model.service;

import com.sound.mall.model.dto.Wishlist;

public interface WishlistService {
	// interface 내부에서는 명시적으로 전부 public이므로 생략
	//찜 개별 조회 - 존재 여부만 확인
	boolean getWishlist(Wishlist wish);
	//찜 목록 추가
	boolean addWishlist(Wishlist wish);
	//찜 목록 삭제
	boolean deleteWishlist(Wishlist wish);
}
