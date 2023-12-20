package com.sound.mall.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.mall.model.dao.WishlistDao;
import com.sound.mall.model.dto.Wishlist;

@Service
public class WishlistServiceImpl implements WishlistService {
	@Autowired
	private WishlistDao wishDao;
	
	@Override
	//찜 개별 조회
	public boolean getWishlist(Wishlist wish) {
		System.out.println(wishDao.getWishlist(wish));
		System.out.println(wishDao.getWishlist(wish) != null);
		return (wishDao.getWishlist(wish) != null);
	}
	//찜 생성
	@Override
	public boolean addWishlist(Wishlist wish) {
		return wishDao.createWishlist(wish) > 0;
	}
	
	//찜 삭제
	@Override
	public boolean deleteWishlist(Wishlist wish) {
		return wishDao.deleteWishlist(wish) > 0;
	}
}
