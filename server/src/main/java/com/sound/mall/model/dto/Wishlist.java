package com.sound.mall.model.dto;

public class Wishlist {
	private int wishlistId;
	private String userId;
	private int itemId;
		
	public Wishlist() {
			
	}
	
	public Wishlist(int wishlistId, String userId, int itemId) {	
		super();
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.itemId = itemId;
	}
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	@Override
	public String toString() {
		return "Wishlist [wishlistId=" + wishlistId + ", userId=" + userId + ", itemId=" + itemId + "]";
	}
}
