package com.faqs.service;

import java.util.List;

import com.faqs.model.Editor;
import com.faqs.model.FileUpload;
//import com.faqs.model.Linux;
import com.faqs.model.Login;
//import com.faqs.model.Unix;
import com.faqs.model.UserForm;

public interface HomePageService<userform> {
	void checkDbConnection();
	Integer save(UserForm userform);
	List<UserForm> listUserDetails();
	public List<UserForm> listuser(Login login);
	public Integer  qustnInsert(Editor obj);
	public List<Editor> listQuestions(Editor ed);
	public Editor searchQustn(Editor demo);
	public Integer  addFile(FileUpload fup);
	public void getJDBC(Editor ed);
	
	
	/*
	 * Integer linuxeditor(Linux obj); Integer unixqustnInsert(Unix obj); public
	 * List<Linux> listLinuxqustn(Linux lin); public List<Unix> listUnixQustns(Unix
	 * un);
	 * 
	 * public Unix searchUnixQustn(Unix demo1);
	 * 
	 * public Linux searchLinuxQustn(Linux demo1);
	 */
	//List<UserForm> listUserDeatails(UserForm userform);
//	List<UserForm> listUserDetails(UserForm userform);

}
