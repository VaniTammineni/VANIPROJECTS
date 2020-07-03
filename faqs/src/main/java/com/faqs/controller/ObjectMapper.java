package com.faqs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faqs.model.Editor;
import com.faqs.service.HomePageService;
import com.faqs.utils.A2zLogMgr;

public class ObjectMapper {
	@Autowired
	private A2zLogMgr logMgr;
	@Autowired
	private HomePageService homeService;
	@RequestMapping("/getByJDBC.htm")
	public void getRecord() {
		Editor ed = 	new Editor();
		homeService.getJDBC(ed);
	}
}
