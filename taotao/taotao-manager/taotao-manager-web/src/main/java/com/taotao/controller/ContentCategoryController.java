package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.service.ContentCategoryService;

@Controller
@RequestMapping(value="/content/category")
public class ContentCategoryController {
	
	@Autowired
	private ContentCategoryService categoryService;
	
	@RequestMapping(value="/list")
	@ResponseBody
	public List<EUTreeNode> getCategoryList(@RequestParam(value="id", defaultValue="0") long parentId){
		List<EUTreeNode> list = categoryService.getContentCategoryList(parentId);
		return list;
	}
}
