package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;

@Controller
public class ItemParamController {
	
	@Autowired
	private ItemParamService paramService;
	
	@RequestMapping(value="/item/param/list",method=RequestMethod.GET)
	@ResponseBody
	public EUDataGridResult itemParamList(Integer page,Integer rows) {
		EUDataGridResult result =  paramService.getItemList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/item/param/query/itemcatid/{itemCatId}",method=RequestMethod.GET)
	@ResponseBody
	public TaotaoResult itemParamWithItemCatId(@PathVariable Long itemCatId){
		TaotaoResult result = paramService.getItemParamWithItemCatId(itemCatId);
		return result;
		
	}
	
	@RequestMapping(value="/item/param/save/{cid}",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult saveitemParam(@PathVariable Long cid,String paramData){
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		TaotaoResult result = paramService.insertItemParam(itemParam);
		return result;
		
	}
	
}
