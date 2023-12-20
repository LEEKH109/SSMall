package com.sound.mall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sound.mall.model.dto.Cart;
import com.sound.mall.model.service.CartService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-cart")
public class CartController {
	
	//cService 라고 하는 친구를 주입
	@Autowired
	private CartService cService;
	
	@PostMapping("regist")
	@ApiOperation(value="상품 카트 추가", notes="카트에 상품 추가")
	public ResponseEntity<Integer> regist(String userId, int itemId, int cnt) {
		Cart tmp = cService.identifyIsCart(userId, itemId);
		// 먼저 있는지 확인
		System.out.println(tmp);
		if(tmp == null) {
		int result = cService.regist(userId, itemId, cnt);			
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		}
		// update를 통해서 개수 +
		int result = cService.update(tmp.getCartId(), tmp.getCnt()+cnt);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@DeleteMapping("delete")
	@ApiOperation(value="상품 제거", notes="카트에서 상품 제거")
	public ResponseEntity<?> delete(String userId,int itemId) {
		int result = cService.delete(userId, itemId);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("deleteChecked")
	@ApiOperation(value="체크 상품 제거", notes="카트에서 체크된 상품 제거")
	public ResponseEntity<?> deleteChecked(String userId) {
		int result = cService.deleteChecked(userId);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@PostMapping("update")
	@ApiOperation(value="상품 개수 변경", notes="카트에서 상품 개수 변경")
	public ResponseEntity<Integer> update(int cartId, int cnt) {
		int result = cService.update(cartId, cnt);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@PostMapping("checked")
	@ApiOperation(value="체크 상태 변경", notes="카트에서 상품의 체크 상태 변경")
	public ResponseEntity<Integer> checked(int cartId) {
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("cartId", cartId);
		int result = cService.updateChecked(paramMap);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	
	@GetMapping("checkedList")
	@ApiOperation(value="체크 상품 출력", notes="카트에서 체크된 상품 출력")
	public ResponseEntity<List<Cart>> checkedList(String userId) {
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("userId", userId);
		List<Cart> clist = cService.cartList(paramMap);
		for(int i = 0;i<clist.size();i++) {
			System.out.println(clist.get(i));
		}
		return new ResponseEntity<List<Cart>>(clist,HttpStatus.OK);
	}
	
	
	@GetMapping("identifyIsCart")
	@ApiOperation(value="상품 존재 확인", notes="카트에서 상품이 있는지 확인")
	public ResponseEntity<Boolean> identifyIsCart(String userId, int itemId){
		Cart result = cService.identifyIsCart(userId, itemId);
		if(result != null) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.OK);
	}
	
	
}