package com.sound.mall.model.service;

import java.util.List;

import com.sound.mall.model.dto.Item;
import com.sound.mall.model.dto.SearchCondition;

public interface ItemService {
	// 상품 전체 조회
	List<Item> getList();
	
	// 상품 하나 조회(ItemId와 일치하는 상품 조회)
	Item getItem(int ItemId);
		
	// 상품등록
	int uploadItem(Item Item);
	
	// 상품 제거
	int removeItem(int ItemId);
	
	// 상품 재고 변경
	int updateItem(int ItemId, int stock, int sellCnt);
	
	// 상품 변경
	int update(Item item);
	
	// 상품 종류별 조회
	List<Item> searchByCategory(SearchCondition condition);	
	
}
