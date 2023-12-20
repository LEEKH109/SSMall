package com.sound.mall.model.dao;

import com.sound.mall.model.dto.Admin;

public interface AdminDao {
	// 유저 생성에 연동되어 작동
	int insertAdmin(Admin admin);
}
