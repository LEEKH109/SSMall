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

import com.sound.mall.model.dto.Ordering;
import com.sound.mall.model.service.OrderingService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-ordering")
public class OrderingController {
	
	//oService 라고 하는 친구를 주입
	@Autowired
	private OrderingService oService;
	
	@PostMapping("insert")
	@ApiOperation(value="상품 추가", notes="ordering에 상품 추가")
	public ResponseEntity<Integer> insert(String userId, int itemId, int cnt) {
		int result = oService.insert(userId, itemId, cnt);			
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}		

	@DeleteMapping("delete")
	@ApiOperation(value="상품 제거", notes="ordering에서 상품 전체 제거")
	public ResponseEntity<?> delete(String userId) {
		int result = oService.delete(userId);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	
	@GetMapping("orderingList")
	@ApiOperation(value="리스트 출력", notes="ordering 리스트 출력")
	public ResponseEntity<List<Ordering>> orderingList(String userId) {
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("userId", userId);
		List<Ordering> olist = oService.orderingList(paramMap);
		return new ResponseEntity<List<Ordering>>(olist,HttpStatus.OK);
	}
	
	
	
	
}