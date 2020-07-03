package com.cs.services;

import java.io.IOException;

import com.cs.bsnlwssb.BsnlwssbDetailsImp;
import com.cs.bsnlwssb.BsnlwssbPayRequest;
import com.cs.bsnlwssb.BsnlwssbPayRequestCB;
import com.cs.bsnlwssb.BsnlwssbPayResponse;
import com.cs.bsnlwssb.BsnlwssbPayResponseCB;
import com.cs.bsnlwssb.BsnlwssbRequestBean;
import com.cs.bsnlwssb.BsnlwssbResponseBean;
import com.cs.bsnlwssb.ChqueResponceBean;

public class CSServices {
	   
    public BsnlwssbResponseBean getBsnlwssbDetails(BsnlwssbRequestBean RequestBean){
    	BsnlwssbResponseBean respList =null;
    	respList=new BsnlwssbResponseBean();
    	BsnlwssbDetailsImp details=new BsnlwssbDetailsImp();
    	respList=details.getBsnlwssbDetails(RequestBean);
	   	return respList;
    }
   public BsnlwssbPayResponse getBsnlwssbPaymentDetails(BsnlwssbPayRequest RequestBean){
    	BsnlwssbPayResponse bean=new BsnlwssbPayResponse();
    	BsnlwssbDetailsImp details=new BsnlwssbDetailsImp();
    	try {
			bean=details.getBsnlwssbPaymentDetails(RequestBean);
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	   	return bean;
    }
    
   public ChqueResponceBean getCheckdefalut(BsnlwssbRequestBean RequestBean){
	ChqueResponceBean respList =null;
   	respList=new ChqueResponceBean();
   	BsnlwssbDetailsImp details=new BsnlwssbDetailsImp();
   	respList=details.getCheckdefalut(RequestBean);
	return respList;
   }
   
   public BsnlwssbPayResponseCB BsnlwssbPaymentCB(BsnlwssbPayRequestCB RequestBean){
	BsnlwssbPayResponseCB bean=new BsnlwssbPayResponseCB();
   	BsnlwssbDetailsImp details=new BsnlwssbDetailsImp();
   	try {
			bean=details.BsnlwssbPaymentCB(RequestBean);
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	   	return bean;
   }
     
    
}
