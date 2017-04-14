package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper paramMapper;

	
	@Override
	public EUDataGridResult getItemList(int page,int rows) {
		PageHelper.startPage(page, rows);
		List<TbItemParam> list = paramMapper.selectTbItemParamList();
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public TaotaoResult getItemParamWithItemCatId(long itemCatId) {
		TbItemParam itemParam = paramMapper.selectByItemCatId(itemCatId);
		if (itemParam!=null) {
			return TaotaoResult.ok(itemParam);
		}
		return TaotaoResult.ok();
	}
	
	@Override
	public TaotaoResult insertItemParam(TbItemParam itemParam) {
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		paramMapper.insert(itemParam);
		return TaotaoResult.ok();
	}

}
