package com.sound.mall.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sound.mall.model.dto.Cart;

public interface CartDao {
	// 카트에 추가
	int insert(Map<String, Object> paramMap);
	// 카트에서 삭제
	int delete(Map<String, Object> paramMap);
	// 체크목록 카트에서 삭제
	int deleteChecked(Map<String, Object> paramMap);
	// 카트에서 수량 변경(장바구니 추가 클릭하면 개수 추가)
	int update(int cartId, int cnt);
	// 체크상태로 변경( 체크된거는 풀기)
	int updateChecked(Map<String, Object> paramMap);
	// 전체 선택
	List<Cart> selectAll(Map<String, Object> paramMap);
	// 체크된 것들 선택
	List<Cart> selectChecked(Map<String, Object> paramMap);
	// 목록 1개 반환
	Cart selectOne(Map<String, Object> paramMap);
	
}
