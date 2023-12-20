package com.sound.mall.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sound.mall.model.dao.AdminDao;
import com.sound.mall.model.dao.UserDao;
import com.sound.mall.model.dto.Admin;
import com.sound.mall.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AdminDao adminDao;
	
	// 회원가입
	@Override
    @Transactional
	public boolean signUp(User user) {
		boolean userCreated = userDao.insertUser(user) > 0;
        if (userCreated) {
            return insertAdminData(user.getUserId());
        }
        return false;
	}
	
	private boolean insertAdminData(String userId) {
        Admin admin = new Admin();
        admin.setUserId(userId);
        admin.setAuthority(false); // 기본적으로 관리자 권한은 부여하지 않습니다.
        return adminDao.insertAdmin(admin) > 0;
    }
	
	// 회원비활성화 - 유저 기능
	@Override
	public boolean userDeactivate(String userId, String password) {
		return userDao.deactivateUser(userId, password) > 0;
	}
	// 회원탈퇴 - 관리자 기능
	@Override
	public boolean deleteUser(String userId, String password) {
		return userDao.deleteUser(userId, password) > 0;
	}
	// 회원정보수정
	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user) > 0;
	}
	// 로그인
	@Override
	public User logIn(String userId, String password) {
		return userDao.selectOne(userId, password);
	}
	// 아이디 중복 체크
	@Override
	public boolean indentifyId(String userId) {
		// 중복되는 아이디가 DB에 존재시 1이상의 값이 반환 
		// 아이디 중복시 false 아닐시 true 반환
		return !(userDao.idValidCheck(userId) > 0);
	}
	// 전체유저조회
	@Override
	public List<User> SelectAllUser() {
		return userDao.getAllUser();
	}

}
