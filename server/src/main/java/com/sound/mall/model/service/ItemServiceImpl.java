package com.sound.mall.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sound.mall.model.dao.ItemDao;
import com.sound.mall.model.dto.Item;
import com.sound.mall.model.dto.SearchCondition;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public List<Item> getList() {
		return itemDao.selectAll();
	}

	@Override
	public Item getItem(int itemId) {
		return itemDao.selectOne(itemId);
	}	

	@Override
	public List<Item> searchByCategory(SearchCondition condition) {
		return itemDao.selectByCategory(condition);
	}

	@Override
	public int uploadItem(Item item) {
		return itemDao.insert(item);
	}

	@Override
	public int removeItem(int itemId) {
		return itemDao.delete(itemId);
	}

	@Override
	public int updateItem(int itemId, int stock, int sellCnt) {
		return itemDao.updateSellCnt(itemId, stock, sellCnt);
	}

	@Override
	public int update(Item item) {
		return itemDao.update(item);
	}

	
	
}
