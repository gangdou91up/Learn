package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper descMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Override
	public TbItem getItemBId(long itemId) {
		TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		return tbItem;
	}
	
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectTbItemList();
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public TaotaoResult createTbItem(TbItem tbItem,String desc,String itemParam) throws Exception {
		long itemId = IDUtils.genItemId();
		tbItem.setId(itemId);
		tbItem.setStatus((byte)1);
		tbItem.setCreated(new Date());
		tbItem.setUpdated(new Date());
		itemMapper.insert(tbItem);
		TaotaoResult result = insertTbItemDesc(itemId, desc);
		
		if (result.getStatus()!=200) {
			throw new Exception();
		}
		result = insertTbItemParamItem(itemId, itemParam);
		if (result.getStatus()!=200) {
			throw new Exception();
		}
		return TaotaoResult.ok();
	}
	
	public TaotaoResult insertTbItemDesc(long itemId,String desc){
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		descMapper.insert(itemDesc);
		return TaotaoResult.ok();
	}
	
	public TaotaoResult insertTbItemParamItem(long itemId,String itemParam) {
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setUpdated(new Date());
		itemParamItem.setCreated(new Date());
		itemParamItem.setParamData(itemParam);
		itemParamItem.setId(itemId);
		itemParamItemMapper.insert(itemParamItem);
		return TaotaoResult.ok();
	}
}
