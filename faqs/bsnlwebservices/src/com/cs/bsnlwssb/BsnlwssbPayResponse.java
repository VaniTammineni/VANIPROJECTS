package com.cs.bsnlwssb;

import java.io.Serializable;

public class BsnlwssbPayResponse implements Serializable {
	
	private String strDeptErrMsg;
	private String strDeptRcptNo;
	private String strResponeCode="",strResponeDesc="";
	
	
	
	public String getStrResponeCode() {
		return strResponeCode;
	}
	public void setStrResponeCode(String strResponeCode) {
		this.strResponeCode = strResponeCode;
	}
	public String getStrResponeDesc() {
		return strResponeDesc;
	}
	public void setStrResponeDesc(String strResponeDesc) {
		this.strResponeDesc = strResponeDesc;
	}
	public String getStrDeptErrMsg() {
		return strDeptErrMsg;
	}
	public void setStrDeptErrMsg(String strDeptErrMsg) {
		this.strDeptErrMsg = strDeptErrMsg;
	}
	public String getStrDeptRcptNo() {
		return strDeptRcptNo;
	}
	public void setStrDeptRcptNo(String strDeptRcptNo) {
		this.strDeptRcptNo = strDeptRcptNo;
	}
	

}
