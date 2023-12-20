package com.sound.mall.model.dao;

import java.util.List;

import com.sound.mall.model.dto.User;

public interface UserDao {
	// 회원가입 - 유저생성
	int insertUser(User user);
	// 회원 탈퇴 - 비활성화
	int deactivateUser(String userId, String password);
	// 회원 탈퇴 - 회원삭제(관리자)
	int deleteUser(String userId, String password);
	// 회원 정보 수정
	int updateUser(User user);
	// 유저 로그인 && 아이디 중복확인
	User selectOne(String userId, String password);
	// 아이디 중복확인 => 있으면 1이상 없으면 0
	int idValidCheck(String userId);
	// 전체 유저조회
	List<User> getAllUser();
}
