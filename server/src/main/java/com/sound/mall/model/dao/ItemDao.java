package com.sound.mall.model.dao;

import java.util.List;

import com.sound.mall.model.dto.Item;
import com.sound.mall.model.dto.SearchCondition;

public interface ItemDao {
	// 아이템 추가
	int insert(Item item);
	// 아이템 삭제
	int delete(int itemId);
	// 아이템 정보 변경
	int update(Item item);
	// 이거를 update로 넣을지 말지 고민
	int updateSellCnt(int itemId, int stock ,int sellCnt);
	// 전체선택
	List<Item> selectAll();
	// 1개 선택
	Item selectOne(int itemId);
	// 검색조건
	List<Item> selectByCategory(SearchCondition conditon);
	
	
	
}
