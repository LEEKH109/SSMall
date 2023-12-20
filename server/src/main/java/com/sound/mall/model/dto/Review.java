package com.sound.mall.model.dto;

public class Review {
	private int reviewId;
	private int itemId;
	private String userId;
	private String name;
	private String explain;
	private int rate;
	public Review() {
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewId, int itemId, String userId, String name, String explain, int rate) {
		super();
		this.reviewId = reviewId;
		this.itemId = itemId;
		this.userId = userId;
		this.name = name;
		this.explain = explain;
		this.rate = rate;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", itemId=" + itemId + ", userId=" + userId + ", name=" + name
				+ ", explain=" + explain + ", rate=" + rate + "]";
	}
	
	
}
