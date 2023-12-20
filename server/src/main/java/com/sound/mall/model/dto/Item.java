package com.sound.mall.model.dto;

public class Item {
	private int itemId;
	private String name;
	private String explain;
	private String detail;
	private String category;
	private int price;
	private int stock;
	private int sellCnt;
	private String img;
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Item(int itemId, String name, String explain, String detail, String category, int price, int stock,
			int sellCnt, String img) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.explain = explain;
		this.detail = detail;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.sellCnt = sellCnt;
		this.img = img;
	}
	public Item(int itemId, String name, String explain, String detail, String category, int price, int stock,
			String img) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.explain = explain;
		this.detail = detail;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.img = img;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getSellCnt() {
		return sellCnt;
	}
	public void setSellCnt(int sellCnt) {
		this.sellCnt = sellCnt;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", explain=" + explain + ", detail=" + detail
				+ ", category=" + category + ", price=" + price + ", stock=" + stock + ", sellCnt=" + sellCnt + ", img="
				+ img + "]";
	}
	
	
	
}
