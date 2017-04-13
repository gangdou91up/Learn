package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.service.PictureService;
import com.taotao.common.utils.JsonUtils;

@Controller

public class PictureController {
	
	@Autowired
	private PictureService picService;
	
	@RequestMapping(value="/pic/upload")
	@ResponseBody
	public String uploadPicture(MultipartFile uploadFile){
		Map resultMap = picService.uploadPicture(uploadFile);
		String result = JsonUtils.objectToJson(resultMap);
		return result;
	}
}
