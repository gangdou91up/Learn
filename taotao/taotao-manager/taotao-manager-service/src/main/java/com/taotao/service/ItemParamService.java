package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

public interface ItemParamService {
	EUDataGridResult getItemList(int page,int rows);
	TaotaoResult getItemParamWithItemCatId(long itemCatId);
	TaotaoResult insertItemParam(TbItemParam itemParam);
}
