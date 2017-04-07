package com.taotao.service.impl;

import com.alibaba.druid.filter.AutoLoad;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

public class ItemServiceImpl implements ItemService{

	private TbItemMapper itemMapper;
	@Override
	public TbItem getItemBId(long itemId) {
		TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		return tbItem;
	}
	
}
