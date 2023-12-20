package com.sound.mall.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.mall.model.dao.CartDao;
import com.sound.mall.model.dto.Cart;
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	@Override
	public int regist(String userId, int itemId, int cnt) {
		 Map<String, Object> paramMap = new HashMap<>();
		    paramMap.put("userId", userId);
		    paramMap.put("itemId", itemId);
		    paramMap.put("cnt", cnt);
		 cartDao.insert(paramMap);
		return 1;
	}

	@Override
	public int delete(String userId, int itemId) {
		 Map<String, Object> paramMap = new HashMap<>();
		    paramMap.put("userId", userId);
		    paramMap.put("itemId", itemId);
		 cartDao.delete(paramMap);
		return 1;
	}
	@Override
	public int update(int cartId, int cnt) {
		int tmp = cartDao.update(cartId, cnt);
		if(tmp == 1) {
			return 1;
		}
		return 0;
	}
	@Override
	public int deleteChecked(String userId) {
		 Map<String, Object> paramMap = new HashMap<>();
		    paramMap.put("userId", userId);
		 cartDao.deleteChecked(paramMap);
		return 1;
	}

	@Override
	public List<Cart> cartList(Map<String, Object> paramMap) {
//		System.out.println(paramMap.containsValue(true));
		if(paramMap.containsValue(true)) {
			return cartDao.selectChecked(paramMap);
		}
		return cartDao.selectAll(paramMap);
	}
	

	@Override
	public Cart identifyIsCart(String userId, int itemId) {
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("userId", userId);
	    paramMap.put("itemId", itemId);

	    Cart tmp = cartDao.selectOne(paramMap);

	    return tmp;
	}


	@Override
	public int updateChecked(Map<String, Object> paramMap) {
		return cartDao.updateChecked(paramMap);
	}

	
	
}
