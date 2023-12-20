package com.sound.mall.model.service;

import java.util.List;

import com.sound.mall.model.dto.User;

public interface UserService {
	// interface 내부에서는 명시적으로 전부 public이므로 생략해도 된다.
	
	// 유저 회원가입
	boolean signUp(User user);
	// 유저 비활성화(유저 기준 회원탈퇴)
	boolean userDeactivate(String userId, String password);
	// 유저 삭제(관리자 기능)
	boolean deleteUser(String userId, String password);
	// 유저 정보 수정
	boolean updateUser(User user);
	// 유저 로그인
	User logIn(String userId, String password);
	// 아이디 중복확인 
	boolean indentifyId(String userId);
	// 전체 유저조회 => 관리자 계정용
	List<User> SelectAllUser();
}
