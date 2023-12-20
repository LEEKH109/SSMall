package com.sound.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sound.mall.model.dto.Item;
import com.sound.mall.model.dto.SearchCondition;
import com.sound.mall.model.service.ItemService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-item")
public class ItemController {
	
	@Autowired 
	private ItemService itemService;

	// 1. 전체 상품 목록 조회
	@GetMapping("/itemList")
	@ApiOperation(value="상품 조회", notes="전체 상품 조회")
	public ResponseEntity<?> list(){
		List<Item> list = itemService.getList();
		if(list == null || list.size() == 0) { // 단축평가
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
	}
	
	// 2. ID와 일치하는 단일 상품 조회
	@GetMapping("/item/{id}")
	@ApiOperation(value="상품 상세 조회", notes="상세 상품 조회")
	public ResponseEntity<Item> detail(@PathVariable int id){
		Item item = itemService.getItem(id);
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	// 3. 상품 등록
	@PostMapping("/item")
	@ApiOperation(value="상품 등록", notes="상품 등록")
	public ResponseEntity<Item> write(Item Item){
		itemService.uploadItem(Item);
		return new ResponseEntity<Item>(Item, HttpStatus.CREATED);
	}
	
	// 4. 상품 삭제
	@DeleteMapping("/item/{id}")
	@ApiOperation(value="상품 삭제", notes="상품 삭제")
	public ResponseEntity<Void> delete(@PathVariable int id){
		itemService.removeItem(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 5. 상품 정보 변경
	@PostMapping("/item/{id}")
	@ApiOperation(value="상품 정보변경" , notes="상품  정보변경")
	public ResponseEntity<Void> update(Item item){
		itemService.update(item);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	// 6. 상품 분류별 조회
	@GetMapping("/item-category")
	@ApiOperation(value="종류 별 상품 조회", notes="종류 별 상품 조회")
	public ResponseEntity<?> listByCategory(SearchCondition condition){
		List<Item> list = itemService.searchByCategory(condition); 
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
	}
	// 7. 상품 재고 변경
		@PostMapping("/updateCnt")
		public ResponseEntity<Integer> updateCnt(int itemId, int stock, int sellCnt){
			int result = itemService.updateItem(itemId, stock, sellCnt);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
	
	
}
