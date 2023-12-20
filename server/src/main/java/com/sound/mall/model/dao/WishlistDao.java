package com.sound.mall.model.dao;

import com.sound.mall.model.dto.Wishlist;

public interface WishlistDao {
	
	//유저별 찜 리스트 전체 조회는 상품 목록에서 조회할 때 join해서 가져오기
	//이 코드에서는 찜 개별 조회, 생성, 삭제만 처리
	//찜 개별 조회
	Wishlist getWishlist(Wishlist wish);
	//찜 생성
	int createWishlist(Wishlist wish);
	//찜 삭제
	int deleteWishlist(Wishlist wish);
}
