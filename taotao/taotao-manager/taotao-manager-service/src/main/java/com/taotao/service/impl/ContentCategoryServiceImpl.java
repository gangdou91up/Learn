package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper categoryMapper;
	@Override
	public List<EUTreeNode> getContentCategoryList(long parentId) {
		//根据父节点查询子节点
		List<TbContentCategory> categoryList = categoryMapper.selectCategoryList();
		List<EUTreeNode> resultList = new ArrayList<>();
		for(TbContentCategory category:categoryList){
			EUTreeNode node = new EUTreeNode();
			node.setId(category.getId());
			node.setText(category.getName());
			node.setState(category.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
	}

}
