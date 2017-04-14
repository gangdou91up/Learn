package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	TbItem getItemBId(long itemId);
	EUDataGridResult getItemList(int page,int rows);
	TaotaoResult createTbItem(TbItem tbItem,String desc,String itemParam) throws Exception;
}
