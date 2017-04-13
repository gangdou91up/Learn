package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper catMapper;
	@Override
	public List<EUTreeNode> getItemCat(Long parentId) {
		List<TbItemCat> nodeList = catMapper.selectTbItemCatList(parentId);
		List<EUTreeNode> resultList = new ArrayList<>();
		for(TbItemCat itemCat:nodeList){
			EUTreeNode node = new EUTreeNode();
			node.setId(itemCat.getId());
			node.setText(itemCat.getName());
			node.setState(itemCat.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
	}
	
}
