package com.faqs.dao;

import java.util.List;

import com.faqs.model.Editor;
import com.faqs.model.FileUpload;
//import com.faqs.model.Linux;
import com.faqs.model.Login;
//import com.faqs.model.Unix;
import com.faqs.model.UserForm;

public interface HomePageDao {
	void checkDbConnection();
	Integer saveUser(UserForm userform);
	List<UserForm> listUserDeatails();
	public List<UserForm> listuser(Login login);
	Integer qustnInsert(Editor obj);
	public List<Editor> listqustns(Editor ed);
	public Editor searchqustns(Editor demo);
	/*
	 * public Integer linuxEditor(Linux obj); public Integer unixEditor(Unix obj);
	 * List<Linux> listLinuxQustn(Linux lin); List<Unix> listUnixQustn(Unix un);
	 * public Unix searchUnixQustn(Unix demo1); public Linux searchLinuxQustn(Linux
	 * demo1);
	 */
	Integer addFile(FileUpload fup);
	public void getByjdbc(Editor ed);
}
