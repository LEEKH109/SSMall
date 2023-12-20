package com.sound.mall.model.service;

import java.util.List;
import java.util.Map;

import com.sound.mall.model.dto.Ordering;

public interface OrderingService {
		// 추가
		public int insert(String userId, int itemId, int cnt);
		// 전체 삭제
		public int delete(String userId);
		// 해당 유저의 주문 중인 목록 조회
		public List<Ordering> orderingList(Map<String, Object> paramMap);
}
