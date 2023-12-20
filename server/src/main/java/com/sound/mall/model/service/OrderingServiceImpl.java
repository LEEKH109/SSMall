package com.sound.mall.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.mall.model.dao.OrderingDao;
import com.sound.mall.model.dto.Ordering;
@Service
public class OrderingServiceImpl implements OrderingService {

	@Autowired
	private OrderingDao orderingDao;
	
	@Override
	public int insert(String userId, int itemId, int cnt) {
		 Map<String, Object> paramMap = new HashMap<>();
		    paramMap.put("userId", userId);
		    paramMap.put("itemId", itemId);
		    paramMap.put("cnt", cnt);
		 orderingDao.insert(paramMap);
		return 1;
	}

	@Override
	public int delete(String userId) {
		 Map<String, Object> paramMap = new HashMap<>();
		    paramMap.put("userId", userId);
		 orderingDao.delete(paramMap);
		return 1;
	}
	

	
	@Override
	public List<Ordering> orderingList(Map<String, Object> paramMap) {
		return orderingDao.selectAll(paramMap);
	}

	
	
}
