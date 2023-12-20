package com.sound.mall.model.dto;

public class User {
	private String userId;
	private String password;
	private String name;
	private String nickName;
	private String email;
	private String birthday;
	private String number;
	private int img;
	private boolean activate;
	public User() {

	}
	
	// 1. 모든 유저정보를 사용하는 User 객체
	public User(String userId, String password, String name, String nickName, String email, String birthday,
			String number, int img, boolean activate) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.nickName = nickName;
		this.email = email;
		this.birthday = birthday;
		this.number = number;
		this.img = img;
		this.activate = activate;
	}

	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getNickName() {
		return nickName;
	}
	public String getEmail() {
		return email;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getNumber() {
		return number;
	}
	public int getImg() {
		return img;
	}
	public boolean getActivate() {
		return activate;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setImg(int img) {
		this.img = img;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", nickName=" + nickName
				+ ", email=" + email + ", birthday=" + birthday + ", number=" + number + ", img=" + img + ", activate="
				+ activate + "]";
	}
}
