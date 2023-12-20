package com.sound.mall.model.service;

import java.util.List;
import java.util.Map;

import com.sound.mall.model.dto.Cart;

public interface CartService {
		// 장바구니 등록
		public int regist(String userId, int itemId, int cnt);
		// 장바구니 삭제
		public int delete(String userId, int itemId);
		// 해당 물품 개수 증가  
		public int update(int cartId, int cnt); // 입력으로 변경된 숫자가 뷰에서 들어옴
		// 장바구니 체크 품목 전체 삭제(구매과정)
		public int deleteChecked(String userId);
		// 해당 유저의 장바구니 목록 조회
		public List<Cart> cartList(Map<String, Object> paramMap);
		// 해당유저가 찜을 했는지 확인 유무
		public Cart identifyIsCart(String userId, int itemId);
		// 체크상태 변경
		public int updateChecked(Map<String, Object> paramMap);
}
