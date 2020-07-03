package com.faqs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faqs.dao.HomePageDao;
import com.faqs.model.Editor;
import com.faqs.model.FileUpload;
//import com.faqs.model.Linux;
import com.faqs.model.Login;
//import com.faqs.model.Unix;
import com.faqs.model.UserForm;

@Service
public class HomePageServiceImplmt implements HomePageService {
	@Autowired
	HomePageDao homePageDao;

	@Override
	public void checkDbConnection() {
		homePageDao.checkDbConnection();
	}

	@Override
	public Integer save(UserForm userform) {
		Integer status= homePageDao.saveUser(userform);
		return status;
	}

	@Override
	public List listUserDetails() {
		homePageDao.listUserDeatails();
		return null;
	}

	@Override
	public List<UserForm> listuser(Login login) {
		return	homePageDao.listuser(login);
	}

	@Override
	public Integer qustnInsert(Editor obj) {
		Integer status= homePageDao.qustnInsert(obj);
		return status;
	}

	@Override
	public List<Editor> listQuestions(Editor ed) {
		// TODO Auto-generated method stub
		return homePageDao.listqustns(ed);
	}

	@Override
	public Editor searchQustn(Editor demo) {
		// TODO Auto-generated method stub
		return homePageDao.searchqustns(demo);
	}

	@Override
	public Integer addFile(FileUpload fup) {
		// TODO Auto-generated method stub
		return homePageDao.addFile(fup);
	}

	@Override
	public void getJDBC(Editor ed) {
		
		homePageDao.getByjdbc(ed);
	}

	/*
	 * @Override public Integer linuxeditor(Linux obj) {
	 * 
	 * return homePageDao.linuxEditor(obj); }
	 * 
	 * @Override public Integer unixqustnInsert(Unix obj) { return
	 * homePageDao.unixEditor(obj); }
	 * 
	 * @Override public List listLinuxqustn(Linux lin) { return
	 * homePageDao.listLinuxQustn(lin); }
	 * 
	 * @Override public List listUnixQustns(Unix un) { return
	 * homePageDao.listUnixQustn(un); }
	 */
	

	/*
	 * @Override public Unix searchUnixQustn(Unix demo1) {
	 * 
	 * return homePageDao.searchUnixQustn(demo1); }
	 * 
	 * @Override public Linux searchLinuxQustn(Linux demo1) {
	 * 
	 * return homePageDao.searchLinuxQustn(demo1); }
	 */
		


}
