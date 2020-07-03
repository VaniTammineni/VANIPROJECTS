package com.faqs.controller;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Decoder;

import com.faqs.model.Editor;
/*import com.faqs.model.Linux;
import com.faqs.model.Unix;*/
import com.faqs.service.HomePageService;
import com.faqs.utils.A2zLogMgr;
import com.google.gson.Gson;
@Controller
public class EditorController {
	private final String CLASS_NAME = this.getClass().getCanonicalName();

	@Autowired
	private A2zLogMgr logMgr;
	@Autowired
	
	private HomePageService homeService;
	
	
	@RequestMapping("/qustns.htm")
	public @ResponseBody String insertQust(@RequestParam(value = "ans") String ans,@RequestParam(value = "text") String text,@RequestParam String qustn,HttpServletRequest request1,
			HttpServletResponse response, ModelMap model) throws IOException, InvalidFormatException{
		final String METHOD_NAME = "homepage";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		try {
			//System.out.println("question is:"+qustn);
			//System.out.println("answer in controller is:"+ans);
			 BufferedImage image = null;
		        byte[] imageByte;
		       
		        	 String result1 = ans;
		        	 //System.out.println("text is"+text);
		        	 byte[] tbyte= text.getBytes();
		        	    //comma is the charater which seperates the prefix and the Base64 String
		        	    int i = result1.indexOf(",");
		        	    result1 = result1.substring(i + 1);
		        	    //System.out.println(result1);
		        	   byte[] encbyte =  result1.getBytes();
		            BASE64Decoder decoder = new BASE64Decoder();
		            imageByte = decoder.decodeBuffer(result1);
		            String base64Image = Base64.getEncoder().encodeToString(imageByte);
		            
		            String result = base64Image;
		            int j = result.indexOf(",");
	        	    result = result.substring(i + 1);
		            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
		            File f = new File("C:\\Users\\Vani\\Desktop\\image.png");
		            if(!f.exists()){
		            	f.createNewFile();
		            }
		            try (OutputStream stream = new FileOutputStream(f)) {
		                stream.write(imageByte);
		               
		            }
		            File file = new File("C:\\Users\\Vani\\Desktop\\image.png");
		            byte[] bFile = new byte[(int) file.length()];

		           /* try {
		    	     FileInputStream fileInputStream = new FileInputStream(file);
		    	     //convert file into array of bytes
		    	     fileInputStream.read(bFile);
		    	     fileInputStream.close();
		            } catch (Exception e) {
		    	     e.printStackTrace();
		            }
		           */ 
		            image = ImageIO.read(bis);
		            BufferedImage img = ImageIO.read(new File("C:\\Users\\Vani\\Desktop\\image.png")); 
		            int width = img.getWidth();
		            int height = img.getHeight();

		            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		            Graphics2D g2d = bufferedImage.createGraphics();

		            // draw graphics
		            g2d.drawImage(img, 75, 50, null);
		            g2d.drawString(text, 10, 35);
		            g2d.setColor(Color.GREEN);

		            g2d.dispose();
		           
		            	File file1 = new File("C:\\Users\\Vani\\Desktop\\image2.png");
		            	ImageIO.write(bufferedImage, "png", file1);
		            	
		            	 FileInputStream fileInputStreamReader = new FileInputStream(file1);
		                 byte[] sbytes = new byte[(int)file.length()];
		                 fileInputStreamReader.read(sbytes);
		               String  encodedfile =  Base64.getEncoder().encodeToString(sbytes);
		               byte[] fbyte = encodedfile.getBytes();
		               
		            	
//		            		            Graphics g = image.getGraphics();
//		            g.setFont(g.getFont().deriveFont(30f));
//		            g.drawString(text, 0, 0);
//		            g.dispose();
//
//		            ImageIO.write(image, "png", new File("C:\\Users\\Vani\\Desktop\\image1.png"));
//		        
//		          
		           
		            image.getClass();
		            bis.close();
		            
		           
		            
		        
			//System.out.println(data);
//			 MultipartFile multipartFile = ((MultipartRequest) request).getFile("file");
//			 Long size = multipartFile.getSize();
//			 System.out.println(size);
//		        String contentType = multipartFile.getContentType();
//		        InputStream in = multipartFile.getInputStream();
//		        byte[] bytes1 = IOUtils.toByteArray(in);
//		       String s= new String(Base64Utils.encode(bytes1));
//		        
//			System.out.println(file);
//			System.out.println(file.getName());
//			System.out.println(ans);
//			byte[] bytes = ans.getBytes();
			Editor obj = new Editor();
			obj.setEditor(fbyte);
			
			obj.setQuestion(qustn);
			
			Integer result3 = homeService.qustnInsert(obj);
		} catch (Exception e) {
			logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME,
					e.getMessage());
		}
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END");
		return "obj";
	}
	
	/*
	 * @RequestMapping("/linuxqustns.htm") public @ResponseBody String
	 * insertLinuxQust(@RequestParam(value = "answer") String
	 * ans,@RequestParam(value = "qustns") String qustn,HttpServletRequest request,
	 * HttpServletResponse response, ModelMap model) throws IOException,
	 * InvalidFormatException{ final String METHOD_NAME = "homepage";
	 * logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY"); try {
	 * System.out.println(ans); byte[] bytes = ans.getBytes(); Linux obj = new
	 * Linux(); obj.setlAnswer(bytes); obj.setlQuestion(qustn); Integer result =
	 * homeService.linuxeditor(obj); } catch (Exception e) {
	 * logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage()); }
	 * logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END"); return "success";
	 * }
	 * 
	 * @RequestMapping("/unixqustns.htm") public @ResponseBody String
	 * insertUnixQust(@RequestParam(value = "ans") String ans,@RequestParam String
	 * qustn,HttpServletRequest request, HttpServletResponse response, ModelMap
	 * model) throws IOException, InvalidFormatException{ final String METHOD_NAME =
	 * "homepage"; logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY"); try
	 * { System.out.println(ans); byte[] bytes = ans.getBytes(); Unix obj = new
	 * Unix(); obj.setuAnswer(bytes); obj.setuQuestion(qustn);
	 * 
	 * Integer result = homeService.unixqustnInsert(obj); } catch (Exception e) {
	 * logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage()); }
	 * logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END"); return "success";
	 * }
	 */
	
	@RequestMapping(value="questions.html", method=RequestMethod.GET)
	public @ResponseBody String qustns(@RequestParam(value = "qstn") String qstn,
			HttpServletResponse response, ModelMap model) throws IOException, InvalidFormatException{
		final String METHOD_NAME = "homepage";
		logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY");
		Editor demo1 = new Editor();
		Gson gson = new Gson();
		String string =null;
		try {
			//System.out.println(qstn);
			
			demo1.setQuestion(qstn);
			demo1.setQustnId(Integer.valueOf(qstn));
			demo1 = homeService.searchQustn(demo1);
			 string = gson.toJson(demo1);
			//System.out.println(string);
				}catch (Exception e) {
		logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME,
				e.getMessage());
	}
	logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END");
	return "editor3";
}
	
	/*
	 * @RequestMapping(value="unixqutions.html", method=RequestMethod.GET)
	 * public @ResponseBody String searchUnixqustns(@RequestParam(value = "qstn")
	 * Integer qstn, HttpServletResponse response, ModelMap model) throws
	 * IOException, InvalidFormatException{ final String METHOD_NAME = "homepage";
	 * logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY"); Unix demo1 = new
	 * Unix(); Gson gson = new Gson(); String string =null; try {
	 * System.out.println(qstn); demo1.setUqustnId(qstn);
	 * //demo1.setUqustnId(Integer.valueOf(qstn)); demo1 =
	 * homeService.searchUnixQustn(demo1); string = gson.toJson(demo1);
	 * System.out.println(string); }catch (Exception e) {
	 * logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage()); }
	 * logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END"); return string; }
	 * 
	 * 
	 * @RequestMapping(value="linuxqutions.html", method=RequestMethod.GET)
	 * public @ResponseBody String searchLinuxqustns(@RequestParam(value = "qstn")
	 * Integer qstn, HttpServletResponse response, ModelMap model) throws
	 * IOException, InvalidFormatException{ final String METHOD_NAME = "homepage";
	 * logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "ENTRY"); Linux demo1 =
	 * new Linux(); Gson gson = new Gson(); String string =null; try {
	 * System.out.println(qstn); demo1.setLqustnId(qstn);
	 * //demo1.setLqustnId(Integer.valueOf(qstn));
	 * 
	 * demo1 = homeService.searchLinuxQustn(demo1); string = gson.toJson(demo1);
	 * System.out.println(string); }catch (Exception e) {
	 * logMgr.writeToError("ERROR", CLASS_NAME, METHOD_NAME, e.getMessage()); }
	 * logMgr.writeToLog("INFO", CLASS_NAME, METHOD_NAME, "END"); return string; }
	 * 
	 * @RequestMapping("/neweditor.htm") public ModelAndView neweditor(){ try{
	 * System.out.println("new editor"); }catch(Exception e){
	 * 
	 * } return new ModelAndView("homePage");
	 * 
	 * }
	 */

	
}


