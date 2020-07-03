package com.faqs.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.faqs.model.FileUpload;
import com.faqs.service.HomePageService;
import com.faqs.utils.A2zLogMgr;

@Controller
public class FileUploadController {
	private final String CLASS_NAME = this.getClass().getCanonicalName();

	@Autowired
	private A2zLogMgr logMgr;
	@Autowired
	private HomePageService homeService;
	
	@RequestMapping(value="/saveUploadedFile.htm",method=RequestMethod.POST)
	public ModelAndView loginpage(HttpServletRequest request,@RequestParam("userId") String userid,
			HttpServletResponse response, ModelMap model, @RequestParam("file") MultipartFile file) throws IOException, InvalidFormatException {
		final String METHOD_NAME = "homepage";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		try {
			InputStream stream = file.getInputStream();
			byte[] bytes = file.getBytes();
			String s = new String(bytes, "UTF-8");
			String fileName = file.getOriginalFilename();
			String filepath = "C:\\Users\\Vani\\Desktop\\" + fileName;
			// Document document = new Document();
			// File f = new File("C:\\Users\\Vani\\Desktop\\" + fileName);
			// if (f.exists() && f.isFile()) {
			// Desktop.getDesktop().open(f);
			// }
			// PdfWriter.getInstance(document, new FileOutputStream(f));
			// document.open();
			// document.add(new Paragraph("hello pdf r u adding"));
			// document.add(new Paragraph(s));
			// document.close();

			/*
			 * BufferedOutputStream bstream = new BufferedOutputStream( new
			 * FileOutputStream(f)); bstream.write(bytes);
			 */

			FileUpload fup = new FileUpload();
			fup.setUserId(userid);
			fup.setFile(bytes);
			fup.setFilePath(filepath);
			homeService.addFile(fup);
			
		} catch (Exception e) {
			logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage());
		}
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END");
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/getTable.htm", method = RequestMethod.POST)
	public @ResponseBody String getTableAjax(HttpServletRequest request,@PathVariable("name") String name,@RequestParam("userId") String userid,
			HttpServletResponse response, ModelMap model, @RequestParam("file") MultipartFile file) throws IOException, InvalidFormatException {
		final String METHOD_NAME = "homepage";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		try {
			System.out.println("file uploading");
			
			
		}catch(Exception e){
			System.out.println(e);
			}
		return "Haivani";
		}
}
