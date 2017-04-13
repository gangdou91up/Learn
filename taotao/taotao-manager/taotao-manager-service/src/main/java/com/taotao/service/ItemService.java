package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	TbItem getItemBId(long itemId);
	EUDataGridResult getItemList(int page,int rows);
}
