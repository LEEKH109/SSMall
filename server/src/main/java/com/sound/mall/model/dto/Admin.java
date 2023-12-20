package com.sound.mall.model.dto;

public class Admin {
	private int adminId;
	private String userId;
	private boolean authority;

	public Admin() {
	}

	public Admin(int adminId, String userId, boolean authority) {
		super();
		this.adminId = adminId;
		this.userId = userId;
		this.authority = authority;
	}

	public int getAdminId() {
		return adminId;
	}

	public String getUserId() {
		return userId;
	}

	public boolean isAuthority() {
		return authority;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setAuthority(boolean authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userId=" + userId + ", authority=" + authority + "]";
	}
}
