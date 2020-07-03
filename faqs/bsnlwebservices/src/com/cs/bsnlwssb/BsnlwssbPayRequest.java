package com.cs.bsnlwssb;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BsnlwssbPayRequest implements Serializable{
	
	private String UserId="",Password="";
	
	private String strTransNo="",strMobileNo="",strPayMode="";
	private String strAccountType="",strRecptNo="",strBillNo="",strUniqId="",strSsaCode="";
	private String strCurDate="",strBillDate="";
	private Double strPaidAmount;
	private String strBankcode="",strChqNo="",strCounter="",strUserCode="",strMechineName="",strChqDate="";
	
	
	public String getStrChqDate() {
		return strChqDate;
	}
	public void setStrChqDate(String strChqDate) {
		this.strChqDate = strChqDate;
	}
	public String getStrMechineName() {
		return strMechineName;
	}
	public void setStrMechineName(String strMechineName) {
		this.strMechineName = strMechineName;
	}
	public String getStrUserCode() {
		return strUserCode;
	}
	public void setStrUserCode(String strUserCode) {
		this.strUserCode = strUserCode;
	}
	public String getStrCounter() {
		return strCounter;
	}
	public void setStrCounter(String strCounter) {
		this.strCounter = strCounter;
	}
	public String getStrChqNo() {
		return strChqNo;
	}
	public void setStrChqNo(String strChqNo) {
		this.strChqNo = strChqNo;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getStrTransNo() {
		return strTransNo;
	}
	public void setStrTransNo(String strTransNo) {
		this.strTransNo = strTransNo;
	}
	public String getStrMobileNo() {
		return strMobileNo;
	}
	public void setStrMobileNo(String strMobileNo) {
		this.strMobileNo = strMobileNo;
	}
	public String getStrPayMode() {
		return strPayMode;
	}
	public void setStrPayMode(String strPayMode) {
		this.strPayMode = strPayMode;
	}
	public String getStrAccountType() {
		return strAccountType;
	}
	public void setStrAccountType(String strAccountType) {
		this.strAccountType = strAccountType;
	}
	public String getStrRecptNo() {
		return strRecptNo;
	}
	public void setStrRecptNo(String strRecptNo) {
		this.strRecptNo = strRecptNo;
	}
	public String getStrBillNo() {
		return strBillNo;
	}
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}
	public String getStrUniqId() {
		return strUniqId;
	}
	public void setStrUniqId(String strUniqId) {
		this.strUniqId = strUniqId;
	}
	public String getStrSsaCode() {
		return strSsaCode;
	}
	public void setStrSsaCode(String strSsaCode) {
		this.strSsaCode = strSsaCode;
	}
	public String getStrCurDate() {
		return strCurDate;
	}
	public void setStrCurDate(String strCurDate) {
		this.strCurDate = strCurDate;
	}
	public String getStrBillDate() {
		return strBillDate;
	}
	public void setStrBillDate(String strBillDate) {
		this.strBillDate = strBillDate;
	}
	public Double getStrPaidAmount() {
		return strPaidAmount;
	}
	public void setStrPaidAmount(Double strPaidAmount) {
		this.strPaidAmount = strPaidAmount;
	}
	public String getStrBankcode() {
		return strBankcode;
	}
	public void setStrBankcode(String strBankcode) {
		this.strBankcode = strBankcode;
	}
	
	
	
	
	

}
