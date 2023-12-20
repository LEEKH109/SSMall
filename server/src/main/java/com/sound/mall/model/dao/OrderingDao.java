package com.sound.mall.model.dao;

import java.util.List;
import java.util.Map;

import com.sound.mall.model.dto.Ordering;

public interface OrderingDao {
	// 주문 중인 목록에 추가
	int insert(Map<String, Object> paramMap);
	// 주문 중인 목록에서 전체 제거
	int delete(Map<String, Object> paramMap);
	// 체크목록 카트에서 삭제
	List<Ordering> selectAll(Map<String, Object> paramMap);
	// 목록 1개 반환 ( 쓸일이 있나?)
	Ordering selectOne(Map<String, Object> paramMap);
	
	
}
