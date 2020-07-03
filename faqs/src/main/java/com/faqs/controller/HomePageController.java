/**
 * 
 */
package com.faqs.controller;

import java.io.IOException;
//import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.faqs.model.Editor;
//import com.faqs.model.Linux;
import com.faqs.model.Login;
//import com.faqs.model.Unix;
import com.faqs.model.UserForm;
import com.faqs.service.HomePageService;
import com.faqs.utils.A2zLogMgr;

/**
 * @author Raveendra
 *
 */
@Controller
public class HomePageController {
	private final String CLASS_NAME = this.getClass().getCanonicalName();

	@Autowired
	private A2zLogMgr logMgr;
	@Autowired
	private HomePageService homeService;

	@RequestMapping(value = "/")
	public ModelAndView homepage(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException, InvalidFormatException {
		final String METHOD_NAME = "homepage";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		/*
		 * List<Linux> linuxList=null; List<Unix> unixList = null;
		 */
		try {
			//homeService.checkDbConnection();
			Editor ed=new Editor();
			
			/*
			 * Linux lin = new Linux(); Unix un = new Unix();
			 */
			  List<Editor> totalList =  homeService.listQuestions(ed); 
			/*
			 * linuxList= homeService.listLinuxqustn(lin); unixList=
			 * homeService.listUnixQustns(un);
			 */
			 
			//System.out.println(totalList.get(0).getEditor().toString());
			model.addAttribute("totalList", totalList);
			/*
			 * model.addAttribute("linuxList", linuxList); model.addAttribute("unixList",
			 * unixList);
			 */
		} catch (Exception e) {
			logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage());
		}
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END");
		return new ModelAndView("homePage");
	}
	
	@RequestMapping(value = "/login.htm")
	public ModelAndView loginpage(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException, InvalidFormatException {
		final String METHOD_NAME = "homepage";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		try {
			
			
		} catch (Exception e) {
			logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage());
		}
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END");
		return new ModelAndView("login");
	}
	
	
	@RequestMapping(value = "/logincred.htm")
	public ModelAndView loginuserType(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException, InvalidFormatException {
		final String METHOD_NAME = "homepage";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		try {

			Login login = new Login();
			String userType = request.getParameter("username");
			String password = request.getParameter("password");
			login.setUsername(userType);
			login.setPassword(password);
			if (userType.equalsIgnoreCase("Admin")) {
				List list = homeService.listuser(login);
				UserForm  obj = (UserForm) list.get(0);
				String cpwd = obj.getPass();
				if(cpwd.equalsIgnoreCase(password)) {
				
				model.addAttribute("userlist", list);
				return new ModelAndView("dashboard");
				}
		}
//			else {
//				return new ModelAndView("uploadFile");
//
//			}
			
			
		} catch (Exception e) {
			logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage());
		}
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END");
		return new ModelAndView("uploadFile");
	}
	
	
	@RequestMapping(value = "/register.htm")
	public ModelAndView registerpage(@ModelAttribute("userform") UserForm userform, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException, InvalidFormatException {
		final String METHOD_NAME = "homepage";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		try { 
			model.addAttribute("user", new UserForm());
			
			
			
		} catch (Exception e) {
			logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage());
		}
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END");
		return new ModelAndView("registerForm");
	}
	
	@RequestMapping(value = "/welcome.htm")
	public ModelAndView afterregister(@ModelAttribute("userform") UserForm userform, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException, InvalidFormatException {
		final String METHOD_NAME = "homepage";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		try { 
			model.addAttribute("user", new UserForm());
		//userform.setSysId(100);
			Integer result = homeService.save(userform);
			//System.out.println(result);
			
			
		} catch (Exception e) {
			logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage());
		}
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END");
		return new ModelAndView("homePage");
	}
	
	@RequestMapping(value = "/questions.htm")
	public ModelAndView javaQustns( HttpServletRequest request,HttpServletResponse response, ModelMap model) throws IOException, InvalidFormatException {
		final String METHOD_NAME = "homepage";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		try { 
		
			
			
		} catch (Exception e) {
			logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage());
		}
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END");
		return new ModelAndView("NewEditor");
	}
	
	@RequestMapping(value = "/unixQuestions.htm")
	public ModelAndView unixQustns( HttpServletRequest request,HttpServletResponse response, ModelMap model) throws IOException, InvalidFormatException {
		final String METHOD_NAME = "homepage";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		try { 
			
		} catch (Exception e) {
			logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage());
		}
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END");
		return new ModelAndView("unixEditor");
	}
	
	@RequestMapping(value = "/linuxQuestions.htm")
	public ModelAndView linuxQustns( HttpServletRequest request,HttpServletResponse response, ModelMap model) throws IOException, InvalidFormatException {
		final String METHOD_NAME = "homepage";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		try { 
		
			
			
		} catch (Exception e) {
			logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage());
		}
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END");
		return new ModelAndView("linuxEditor");
	}
}
