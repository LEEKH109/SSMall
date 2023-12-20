package com.sound.mall.model.dto;

public class Cart {
		private int cartId;
	    private String userId;
	    private int itemId;
	    private int cnt;
	    private boolean checked;
	    
	    private String itemName;
	    private String itemExplain;
	    private String itemDetail;
	    private String itemCategory;
	    private int itemPrice;
	    private int itemStock;
	    private String itemImg;
	    private int totalItems;
	    private int totalPrice;
	    public Cart() {
			// TODO Auto-generated constructor stub
		}
		public Cart(int cartId, String userId, int itemId, int cnt, boolean checked, String itemName,
				String itemExplain, String itemDetail, String itemCategory, int itemPrice, int itemStock,
				String itemImg, int totalItems, int totalPrice) {
			super();
			this.cartId = cartId;
			this.userId = userId;
			this.itemId = itemId;
			this.cnt = cnt;
			this.checked = checked;
			this.itemName = itemName;
			this.itemExplain = itemExplain;
			this.itemDetail = itemDetail;
			this.itemCategory = itemCategory;
			this.itemPrice = itemPrice;
			this.itemStock = itemStock;
			this.itemImg = itemImg;
			this.totalItems = totalItems;
			this.totalPrice = totalPrice;
		}
		public Cart(int cartId, String userId, int itemId, int cnt, boolean checked) {
			super();
			this.cartId = cartId;
			this.userId = userId;
			this.itemId = itemId;
			this.cnt = cnt;
			this.checked = checked;
		}
		public int getCartId() {
			return cartId;
		}
		public void setCartId(int cartId) {
			this.cartId = cartId;
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
		public int getCnt() {
			return cnt;
		}
		public void setCnt(int cnt) {
			this.cnt = cnt;
		}
		public boolean isChecked() {
			return checked;
		}
		public void setChecked(boolean checked) {
			this.checked = checked;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public String getItemExplain() {
			return itemExplain;
		}
		public void setItemExplain(String itemExplain) {
			this.itemExplain = itemExplain;
		}
		public String getItemDetail() {
			return itemDetail;
		}
		public void setItemDetail(String itemDetail) {
			this.itemDetail = itemDetail;
		}
		public String getItemCategory() {
			return itemCategory;
		}
		public void setItemCategory(String itemCategory) {
			this.itemCategory = itemCategory;
		}
		public int getItemPrice() {
			return itemPrice;
		}
		public void setItemPrice(int itemPrice) {
			this.itemPrice = itemPrice;
		}
		public int getItemStock() {
			return itemStock;
		}
		public void setItemStock(int itemStock) {
			this.itemStock = itemStock;
		}
		public String getItemImg() {
			return itemImg;
		}
		public void setItemImg(String itemImg) {
			this.itemImg = itemImg;
		}
		public int getTotalItems() {
			return totalItems;
		}
		public void setTotalItems(int totalItems) {
			this.totalItems = totalItems;
		}
		public int getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(int totalPrice) {
			this.totalPrice = totalPrice;
		}
		@Override
		public String toString() {
			return "Cart [cartId=" + cartId + ", userId=" + userId + ", itemId=" + itemId + ", cnt=" + cnt
					+ ", checked=" + checked + ", itemName=" + itemName + ", itemExplain=" + itemExplain
					+ ", itemDetail=" + itemDetail + ", itemCategory=" + itemCategory + ", itemPrice=" + itemPrice
					+ ", itemStock=" + itemStock + ", itemImg=" + itemImg + ", totalItems=" + totalItems
					+ ", totalPrice=" + totalPrice + "]";
		}
	    
}
