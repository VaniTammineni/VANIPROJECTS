package com.faqs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.faqs.service.HomePageService;
import com.faqs.utils.A2zLogMgr;

@Controller
public class CacheController {
	@Autowired
	private A2zLogMgr logMgr;
	@Autowired
	private HomePageService homeService;
	@RequestMapping("/cache.htm")
	public String cachePractice(HttpServletRequest req,HttpServletResponse response){
		try{
			List l = homeService.listUserDetails();
		}catch(Exception e){
			
		}
		return "upload";
		
	}
	
	@RequestMapping("/uploadinggg.htm")
	public void cacheuploade(@RequestParam("file") MultipartFile file,HttpServletRequest req,HttpServletResponse response){
		try{
			long size= file.getSize();
			System.out.println(size);
		}catch(Exception e){
			
		}
		
		
	}
}
