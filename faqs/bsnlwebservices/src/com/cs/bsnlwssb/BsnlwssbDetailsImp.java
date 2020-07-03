package com.cs.bsnlwssb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringEscapeUtils;

import com.db.DBConnectionClass;




public class BsnlwssbDetailsImp {
	private Connection conObj;
	private Statement stmtObj;
	private ResultSet rsObj;
	
	String strQry="";
	
	
	public BsnlwssbResponseBean getBsnlwssbDetails(BsnlwssbRequestBean RequestBean){
		BsnlwssbResponseBean ResponeBean = null;
		String strBillNo="",strUniqueId="",strPayableAmt="",strOsSurcharge="",strSurCharge="",strPhoneNoo="",strCustomerName="";
		ResponeBean=new BsnlwssbResponseBean();
		StringBuffer sb = new StringBuffer();
		String strExCode="",strBilldate="",strPaydate="",strAccType="",strBalance="",strPaydateCheck="",strClassCode="",strPaydatecom="";
	    try{//Main Try	
	    
	    
			try{
				conObj=DBConnectionClass.getConnection();	         
				stmtObj=conObj.createStatement(); 
				}catch(Exception e){
				ResponeBean.setStrResponeCode("101");
				ResponeBean.setStrResponeDesc(e.toString());
				return ResponeBean;
				}

			if(!RequestBean.getUserId().equals("ESEVA")){
					ResponeBean.setStrResponeCode("132");
					ResponeBean.setStrResponeDesc("USERID WRONG");
					return ResponeBean;
			 }
			if(!RequestBean.getPassword().equals("ESEVA@123#789")){
				ResponeBean.setStrResponeCode("132");
				ResponeBean.setStrResponeDesc("PASSWORD WRONG");
				return ResponeBean;
		    }
	        //-----------------GET CONSUMER DETAILS---------------
			
			
			         try{
			        	 
			        /*if(RequestBean.getStrBillNo()!=""){	 
			         strQry=" SELECT BILL_NO,UNIQUE_ID_NO,NVL(PAYABLE_AMOUNT,0)," +
			         		"PHONE_NO,NVL(SURCHARGE,0),NVL(OS_SURCHARGE,0),REPLACE(replace(CUSTOMER_NAME,'''',' '), '-',' '),EXCHANGE_CODE,TO_CHAR(BILL_DATE,'DD-MM-YYYY'),TO_CHAR(PAY_BY_DATE,'DD-MM-YYYY'),nvl(ACCOUNT_TYPE,'CDR'),NVL(PAYABLE_AMOUNT,0)+NVL(OS_SURCHARGE,0)+NVL(SURCHARGE,0),ROUND(SYSDATE-(PAY_BY_DATE+6)),nvl(substr(CLASS_CODE,1,2),'0'),NVL(MONTHS_BETWEEN(PAY_BY_DATE,SYSDATE),0) " +
			         		"FROM V_BSNL_BILL_MASTER WHERE BILL_NO='"+RequestBean.getStrBillNo()+"' AND EXCHANGE_CODE='HYD' ";
			        }else if(RequestBean.getStrPhoneNo()!=""){
			        	strQry=" SELECT BILL_NO,UNIQUE_ID_NO,NVL(PAYABLE_AMOUNT,0),PHONE_NO," +
			        			"NVL(SURCHARGE,0),NVL(OS_SURCHARGE,0),REPLACE(replace(CUSTOMER_NAME,'''',' '), '-',' '),EXCHANGE_CODE,TO_CHAR(BILL_DATE,'DD-MM-YYYY'),TO_CHAR(PAY_BY_DATE,'DD-MM-YYYY'),nvl(ACCOUNT_TYPE,'CDR'),NVL(PAYABLE_AMOUNT,0)+NVL(OS_SURCHARGE,0)+NVL(SURCHARGE,0),ROUND(SYSDATE-(PAY_BY_DATE+6)),nvl(substr(CLASS_CODE,1,2),'0'),NVL(MONTHS_BETWEEN(PAY_BY_DATE,SYSDATE),0) " +
			        			"FROM V_BSNL_BILL_MASTER WHERE PHONE_NO='"+RequestBean.getStrPhoneNo()+"' AND EXCHANGE_CODE='HYD' ";
			        }else if(RequestBean.getStrUniqueNo()!=""){
			        	strQry=" SELECT BILL_NO,UNIQUE_ID_NO,NVL(PAYABLE_AMOUNT,0),PHONE_NO," +
			        			"NVL(SURCHARGE,0),NVL(OS_SURCHARGE,0),REPLACE(replace(CUSTOMER_NAME,'''',' '), '-',' '),EXCHANGE_CODE,TO_CHAR(BILL_DATE,'DD-MM-YYYY'),TO_CHAR(PAY_BY_DATE,'DD-MM-YYYY'),nvl(ACCOUNT_TYPE,'CDR'),NVL(PAYABLE_AMOUNT,0)+NVL(OS_SURCHARGE,0)+NVL(SURCHARGE,0),ROUND(SYSDATE-(PAY_BY_DATE+6)),nvl(substr(CLASS_CODE,1,2),'0'),NVL(MONTHS_BETWEEN(PAY_BY_DATE,SYSDATE),0) FROM " +
			        			"V_BSNL_BILL_MASTER WHERE UNIQUE_ID_NO='"+RequestBean.getStrUniqueNo()+"' AND EXCHANGE_CODE='HYD' ";
			        }else{
			        	 ResponeBean.setStrResponeCode("222");
						 ResponeBean.setStrResponeDesc("CONSUMER DATA NOT AVAILABLE");
						 return ResponeBean;
			        }*/
			        strQry=" SELECT BILL_NO,UNIQUE_ID_NO,NVL(PAYABLE_AMOUNT,0),PHONE_NO," +
				    "NVL(SURCHARGE,0),NVL(OS_SURCHARGE,0),REPLACE(replace(CUSTOMER_NAME,'''',' '), '-',' '),EXCHANGE_CODE,TO_CHAR(BILL_DATE,'DD-MM-YYYY'),TO_CHAR(PAY_BY_DATE,'DD-MM-YYYY'),nvl(ACCOUNT_TYPE,'CDR'),NVL(PAYABLE_AMOUNT,0)+NVL(OS_SURCHARGE,0)+NVL(SURCHARGE,0),ROUND(SYSDATE-(PAY_BY_DATE+6)),nvl(substr(CLASS_CODE,1,2),'0'),NVL(MONTHS_BETWEEN(PAY_BY_DATE,SYSDATE),0) FROM " +
				    "V_BSNL_BILL_MASTER WHERE (UNIQUE_ID_NO='"+RequestBean.getStrUniqueNo()+"' OR BILL_NO='"+RequestBean.getStrBillNo()+"' OR PHONE_NO='"+RequestBean.getStrPhoneNo()+"') ";
			        
			         System.out.println("--------"+strQry);
			         rsObj=stmtObj.executeQuery(strQry);
			         sb.append("<BsnlRec>");
			        

			         if(rsObj.isBeforeFirst()==false){
			        	 ResponeBean.setStrResponeCode("105");
						 ResponeBean.setStrResponeDesc("CONSUMER DATA NOT AVAILABLE");
						 return ResponeBean;
			         }
//			      
			        	 while(rsObj.next()){
			        	 sb.append("<response>");
			        	 strBillNo	=rsObj.getString(1).trim();           
			        	 strUniqueId=rsObj.getString(2).trim();
			        	 strPayableAmt=rsObj.getString(3).trim();
			        	 strPhoneNoo=rsObj.getString(4).trim();
			        	 strSurCharge	=rsObj.getString(5).trim();
			        	 strOsSurcharge	=rsObj.getString(6).trim();
			        	 strCustomerName=rsObj.getString(7).trim();
			        	 strExCode	    =rsObj.getString(8).trim();
			        	 strBilldate	=rsObj.getString(9).trim();
			        	 strPaydate	    =rsObj.getString(10).trim();
			        	 strAccType	    =rsObj.getString(11).trim();
			        	 strBalance		=rsObj.getString(12).trim();
			        	 strPaydateCheck =rsObj.getString(13).trim();
			        	 strClassCode   =rsObj.getString(14).trim();
			        	 strPaydatecom   =rsObj.getString(15).trim();
			        	 sb.append("<strBillNo>" + strBillNo + "</strBillNo>");
			        	 sb.append("<strUniqueId>" + strUniqueId + "</strUniqueId>");
			        	 sb.append("<strPayableAmt>" + strPayableAmt + "</strPayableAmt>");
			        	 sb.append("<strPhoneNoo>" + strPhoneNoo + "</strPhoneNoo>");
			        	 sb.append("<strSurCharge>" + strSurCharge + "</strSurCharge>");
			        	 sb.append("<strOsSurcharge>" + strOsSurcharge + "</strOsSurcharge>");
			        	 sb.append("<strCustomerName>" + StringEscapeUtils.escapeXml(strCustomerName) + "</strCustomerName>");
			        	 sb.append("<strExCode>" + strExCode + "</strExCode>");
			        	 sb.append("<strBilldate>" + strBilldate + "</strBilldate>");
			        	 sb.append("<strPaydate>" + strPaydate + "</strPaydate>");
			        	 sb.append("<strAccType>" + strAccType + "</strAccType>");
			        	 sb.append("<strBalance>" + strBalance + "</strBalance>");
			        	 sb.append("<strPaydateCheck>" + strPaydateCheck + "</strPaydateCheck>");
			        	 sb.append("<strClassCode>" + strClassCode + "</strClassCode>");
			        	 sb.append("<strPaydatecom>" + strPaydatecom + "</strPaydatecom>");
			             sb.append("</response>");
			        	 }
			        	 sb.append("</BsnlRec>");
			             String strRes = sb.toString();
				         System.out.println(strRes.toString());
				         ResponeBean.setStrXml(strRes.toString());
			        	 ResponeBean.setStrResponeCode("000");
						 ResponeBean.setStrResponeDesc("-----"); 
			        }catch(Exception e){
			        		conObj.rollback();
							ResponeBean.setStrResponeCode("101");
							ResponeBean.setStrResponeDesc("DATA BASE SHUT DOWN,PLEASE DO AFTER SOME TIME");
							return ResponeBean;
					}
				
			
		}catch(Exception e){
			ResponeBean.setStrResponeCode("101");
			ResponeBean.setStrResponeDesc("DATA BASE SHUT DOWN,PLEASE DO AFTER SOME TIME");
			return ResponeBean;
		}finally{
        	try {
				if(rsObj !=null)
	        	{rsObj.close();}
        		if(stmtObj !=null)
	        	{stmtObj.close();}
        		if(conObj !=null)
	        	{conObj.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

		return ResponeBean;
		
	}
	public BsnlwssbPayResponse getBsnlwssbPaymentDetails(BsnlwssbPayRequest PayBean) throws Exception, IOException{
		BsnlwssbPayResponse ResponeBean=new BsnlwssbPayResponse();
		String strPayMode="";	
		String strLTransUpQry = null;
 	   String strLTransUpQry1 = null;
 	   DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
	    try{//Main Try	
	    	try{
				conObj=DBConnectionClass.getConnection();	         
				stmtObj=conObj.createStatement(); 
				}catch(Exception e){
				ResponeBean.setStrResponeCode("101");
				ResponeBean.setStrResponeDesc(e.toString());
				return ResponeBean;
				}
			if(PayBean.getUserId().equals("")|| PayBean.getPassword().equals("")){
						ResponeBean.setStrResponeCode("104");
						ResponeBean.setStrResponeDesc("INSUFFICIENT VALUES PROVIDED");
						return ResponeBean;
			}
			if(!PayBean.getUserId().equals("ESEVA")){
					ResponeBean.setStrResponeCode("132");
					ResponeBean.setStrResponeDesc("USERID WRONG");
					return ResponeBean;
			 }
			if(!PayBean.getPassword().equals("ESEVA@123#789")){
				ResponeBean.setStrResponeCode("132");
				ResponeBean.setStrResponeDesc("PASSWORD WRONG");
				return ResponeBean;
		    }
			/*if(!PayBean.getStrRecptNo().substring(2, 6).equalsIgnoreCase("TSTS")){
			   String strCrossCheck="SELECT M.TW_TRAN_NO TW_TRAN_NO,M.TW_TRAN_DATE TW_TRAN_DATE," +
	            		"M.PAY_MODE PAY_MODE,D.CHQDD_CARD_NO CHQDD_CARD_NO,to_char(D.CHQDD_DATE,'DD-MM-YYYY') CHQDD_DATE," +
	            		"D.BANK_CODE||D.BRANCH_CODE,D.FAVOF_DEPT FAVOF_DEPT FROM " +
	            		"TW_TRANS M,TW_TRANS_PAY_DTLS D WHERE M.DEPT_CODE='10' AND  " +
	            		"D.TW_TRAN_NO(+)=M.TW_TRAN_NO AND M.TRAN_STATUS='N' AND FSTATUS='N' " +
	            		"AND M.TW_TRAN_NO='"+PayBean.getStrTransNo()+"'"; 
			   System.out.println(strCrossCheck);
	            rsObj=stmtObj.executeQuery(strCrossCheck);
	            if(rsObj.next()){
	            	strPayMode      = rsObj.getString(3);
	              }else{
	            	  ResponeBean.setStrResponeCode("777");
					  ResponeBean.setStrResponeDesc("DATA BASE SHUT DOWN,PLEASE DO AFTER SOME TIME");
					  return ResponeBean;
	             }
			}*/
	            try{
	            
	           try{ 
	        	/*if(!PayBean.getStrRecptNo().substring(2, 6).equalsIgnoreCase("TSTS")){
                strLTransUpQry = "INSERT INTO TW_TRANS_BSNL_DTLS(TW_TRAN_NO,PHONE_NO,BILL_DATE,BSNL_BANK_CODE,TW_TRAN_DATE,ACCOUNT_TYPE,SSA_CODE)"
        				+ " values('"+PayBean.getStrTransNo() + "','" + PayBean.getStrMobileNo() + "', TO_DATE('" + PayBean.getStrBillDate() + "','DD-MM-YYYY')," +
        				"'"+PayBean.getStrBankcode()+ "',TO_DATE('" + PayBean.getStrCurDate() + "'," + "'DD-MM-YYYY'),'" + PayBean.getStrAccountType() + "','"+PayBean.getStrSsaCode()+"' )";
                System.out.println(strLTransUpQry);
                stmtObj.execute(strLTransUpQry); 
                
	        	System.out.println("--------"+PayBean.getStrChqDate());
	        	
	        	 String strLTransUpQry2 = "UPDATE TW_TRANS SET DEPT_RCPT_NO = '" + PayBean.getStrRecptNo() +"', " +
			        		" DEPT_RCPT_DT =TO_DATE('"+PayBean.getStrCurDate()+ "'," + "'DD-MM-YYYY')"  + 
							", REMOTE_UPDATE = 'Y',REMOTE_UPD_DATE=SYSDATE WHERE TW_TRAN_NO = '" + PayBean.getStrTransNo() +"'"; 
					 System.out.println(strLTransUpQry2);
			         stmtObj.addBatch(strLTransUpQry2); 
	        	}*/
	        	
	        	
       			strLTransUpQry1 = "INSERT INTO V_BSNL_TWINS_RECEIPT_MASTER" +
       					"(RECEIPT_NO,RECEIPT_DATE,RECEIPT_AMOUNT,PAYMENT_MODE,INSTRUMENT_NO," +
       					"INSTRUMENT_DATE,BANK_PO_CODE,PAYMENT_REALISED,COLLECTION_TML_CODE,USER_CODE," +
       					"BILL_NO,UNIQUE_ID_NO,MACHINE_NAME,ACCOUNT_TYPE,SSA_CODE)"
        				+ " values('"+PayBean.getStrRecptNo()+ "',TO_DATE('"+PayBean.getStrCurDate()+ "'," +
        				"'DD-MM-YYYY'),'"+PayBean.getStrPaidAmount()+ "','" + PayBean.getStrPayMode() + "'," +
        				"'" +PayBean.getStrChqNo()+ "',TO_DATE('"+PayBean.getStrChqDate()+ "','DD-MM-YYYY') ," +
        				"'" + PayBean.getStrBankcode()+ "','Y', '" + PayBean.getStrCounter()+"' ," +
        				"'" + PayBean.getStrUserCode()+ "','"+PayBean.getStrBillNo()+ "','" +PayBean.getStrUniqId()+ "'," +
        				"'" + PayBean.getStrMechineName()+ "' ,'"+PayBean.getStrAccountType()+"' ,'"+PayBean.getStrSsaCode()+"')"; 
       			
       					System.out.println(strLTransUpQry1);
       					stmtObj.addBatch(strLTransUpQry1); 
				
				
		        		
		        	   stmtObj.executeBatch();
		        	   conObj.commit();  
		        	   ResponeBean.setStrResponeCode("000");
		        	   ResponeBean.setStrResponeDesc("SUCCESS");
		        	   
	           }catch(Exception e){
        		   conObj.rollback();
			       System.out.println(e.toString());
				   ResponeBean.setStrResponeCode("111");
				   ResponeBean.setStrResponeDesc("DATA BASE SHUT DOWN,PLEASE DO AFTER SOME TIME"+e.toString());
				   return ResponeBean;
			   }
			 
	            }catch(Exception e){
				       conObj.rollback();
				       System.out.println("-------"+e.toString());
					   ResponeBean.setStrResponeCode("101");
					   ResponeBean.setStrResponeDesc("DATA BASE SHUT DOWN,PLEASE DO AFTER SOME TIME");
					   return ResponeBean;
				 }
			
		}catch(Exception e){
			ResponeBean.setStrResponeCode("101");
			ResponeBean.setStrResponeDesc("DATA BASE SHUT DOWN,PLEASE DO AFTER SOME TIME");
			return ResponeBean;
		}finally{
        	try {
				if(rsObj !=null)
	        	{rsObj.close();}
        		if(stmtObj !=null)
	        	{stmtObj.close();}
        		if(conObj !=null)
	        	{conObj.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

		return ResponeBean;
		
	} 
	
	public ChqueResponceBean  getCheckdefalut(BsnlwssbRequestBean RequestBean){
		
		ChqueResponceBean ResponeBean=new ChqueResponceBean();
		String strDiff="";	
	    try{//Main Try	
 	
			try{
				conObj=DBConnectionClass.getConnection();	         
				stmtObj=conObj.createStatement(); 
				}catch(Exception e){
				ResponeBean.setStrResponeCode("101");
				ResponeBean.setStrResponeDesc(e.toString());
				return ResponeBean;
				}
		
			if(!RequestBean.getUserId().equals("ESEVA")){
					ResponeBean.setStrResponeCode("132");
					ResponeBean.setStrResponeDesc("USERID WRONG");
					return ResponeBean;
			 }
			if(!RequestBean.getPassword().equals("ESEVA123#789")){
				ResponeBean.setStrResponeCode("132");
				ResponeBean.setStrResponeDesc("PASSWORD WRONG");
				return ResponeBean;
		    }
	        //-----------------GET CONSUMER DETAILS---------------
			         try{
			        	 String strConnQry = "SELECT NVL(ADD_MONTHS(MAX(TO_DATE(TW_TRAN_DATE,'DD-MON-YY')), 6)-TO_DATE(SYSDATE),0) FROM   " +
			        	 		"TW_TRANS WHERE  CONSUMER_NO='"+RequestBean.getStrUniqueNo()+"' AND DEPT_CODE ='10'  AND Tran_Status ='B'"; 
			        	      rsObj=stmtObj.executeQuery(strConnQry);
			     		       if(rsObj.next()){
			     		    	  strDiff=rsObj.getString(1).trim(); 
			     		    	}else{
			     		    		ResponeBean.setStrResponeCode("102");
									ResponeBean.setStrResponeDesc("THE LOCAL SERVER DOWN");
									return ResponeBean;
			     		    	}
			     		      if(Integer.parseInt(strDiff)>0){
			     		    	  	ResponeBean.setStrResponeCode("103");
			     		    	  	ResponeBean.setStrResponeDesc("Pay modes available are {CASH/DD");
			     		    	  	return ResponeBean;
			     				}else{
			     					 ResponeBean.setStrResponeCode("555");
									 ResponeBean.setStrResponeDesc("SUCCESS");
									// return ResponeBean;
			     				}
			     						 		
				       
						 
          		     }catch(Exception e){
			        		conObj.rollback();
							ResponeBean.setStrResponeCode("101");
							ResponeBean.setStrResponeDesc("DATA BASE SHUT DOWN,PLEASE DO AFTER SOME TIME");
							return ResponeBean;
					}
		}catch(Exception e){
			ResponeBean.setStrResponeCode("101");
			ResponeBean.setStrResponeDesc("DATA BASE SHUT DOWN,PLEASE DO AFTER SOME TIME");
			return ResponeBean;
		}finally{
        	try {
				if(rsObj !=null)
	        	{rsObj.close();}
        		if(stmtObj !=null)
	        	{stmtObj.close();}
        		if(conObj !=null)
	        	{conObj.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

		return ResponeBean;
		
	}
	
	public BsnlwssbPayResponseCB BsnlwssbPaymentCB(BsnlwssbPayRequestCB PayBean) throws Exception, IOException{
		BsnlwssbPayResponseCB ResponeBean=new BsnlwssbPayResponseCB();
		String strPayMode="";	
		String strLTransUpQry = null;
 	   String strLTransUpQry1 = null;
 	   DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
	    try{//Main Try	
	    	try{
				conObj=DBConnectionClass.getConnection();	         
				stmtObj=conObj.createStatement(); 
				}catch(Exception e){
				ResponeBean.setStrResponeCode("101");
				ResponeBean.setStrResponeDesc(e.toString());
				return ResponeBean;
				}
			if(PayBean.getUserId().equals("")|| PayBean.getPassword().equals("")){
						ResponeBean.setStrResponeCode("104");
						ResponeBean.setStrResponeDesc("INSUFFICIENT VALUES PROVIDED");
						return ResponeBean;
			}
			if(!PayBean.getUserId().equals("ESEVA")){
					ResponeBean.setStrResponeCode("132");
					ResponeBean.setStrResponeDesc("USERID WRONG");
					return ResponeBean;
			 }
			if(!PayBean.getPassword().equals("ESEVA@123#789")){
				ResponeBean.setStrResponeCode("132");
				ResponeBean.setStrResponeDesc("PASSWORD WRONG");
				return ResponeBean;
		    }
			
			if(PayBean.getStrRecptNo().equals("NA")){
				ResponeBean.setStrResponeCode("146");
				ResponeBean.setStrResponeDesc("Dept Rect No null");
				return ResponeBean;
		    }
			
			  /* String strCrossCheck="SELECT M.TW_TRAN_NO TW_TRAN_NO,M.TW_TRAN_DATE TW_TRAN_DATE," +
	            		"M.PAY_MODE PAY_MODE,D.CHQDD_CARD_NO CHQDD_CARD_NO,to_char(D.CHQDD_DATE,'DD-MM-YYYY') CHQDD_DATE," +
	            		"D.BANK_CODE||D.BRANCH_CODE,D.FAVOF_DEPT FAVOF_DEPT FROM " +
	            		"TW_TRANS M,TW_TRANS_PAY_DTLS D WHERE M.DEPT_CODE='10' AND  " +
	            		"D.TW_TRAN_NO(+)=M.TW_TRAN_NO AND M.TRAN_STATUS='N' AND FSTATUS='C' " +
	            		"AND M.TW_TRAN_NO='"+PayBean.getStrOldTranno()+"'"; 
			   System.out.println(strCrossCheck);
	            rsObj=stmtObj.executeQuery(strCrossCheck);
	            if(rsObj.next()){
	            	strPayMode      = rsObj.getString(3);
	              }else{
	            	  ResponeBean.setStrResponeCode("777");
					  ResponeBean.setStrResponeDesc("DATA BASE SHUT DOWN,PLEASE DO AFTER SOME TIME");
					  return ResponeBean;
	             }*/
	            
	            try{
	            
	           try{ 
                strLTransUpQry1 = "INSERT INTO V_BSNL_TWINS_RECEIPT_MASTER" +
       					"(RECEIPT_NO,RECEIPT_DATE,RECEIPT_AMOUNT,PAYMENT_MODE,INSTRUMENT_NO," +
       					"INSTRUMENT_DATE,BANK_PO_CODE,PAYMENT_REALISED,COLLECTION_TML_CODE,USER_CODE," +
       					"BILL_NO,UNIQUE_ID_NO,MACHINE_NAME,ACCOUNT_TYPE,SSA_CODE)"
        				+ " values('"+PayBean.getStrRecptNo()+ "',TO_DATE('"+PayBean.getStrCurDate()+ "'," +
        				"'DD-MM-YYYY'),'"+PayBean.getStrPaidAmount()+ "','" + PayBean.getStrPayMode() + "'," +
        				"'" +PayBean.getStrChqNo()+ "',TO_DATE('"+PayBean.getStrChqDate()+ "','DD-MM-YYYY') ," +
        				"'" + PayBean.getStrBankcode()+ "','I', '" + PayBean.getStrCounter()+"' ," +
        				"'" + PayBean.getStrUserCode()+ "','"+PayBean.getStrBillNo()+ "','" +PayBean.getStrUniqId()+ "'," +
        				"'" + PayBean.getStrMechineName()+ "' ,'"+PayBean.getStrAccountType()+"' ,'"+PayBean.getStrSsaCode()+"')"; 
       		 System.out.println(strLTransUpQry1);
       					stmtObj.addBatch(strLTransUpQry1); 
       					
       					String OldDeptUpdate="UPDATE V_BSNL_TWINS_RECEIPT_MASTER SET PAYMENT_REALISED='X' " +
       							"WHERE RECEIPT_NO='"+PayBean.getStrRecptOldNo()+"' AND BILL_NO = '"+PayBean.getStrBillNo()+ "' " +
       							"AND RECEIPT_DATE=TO_DATE('"+PayBean.getStrCurDate()+"','DD-MM-YYYY')";
       					System.out.println(OldDeptUpdate);
       					stmtObj.addBatch(OldDeptUpdate); 
				String strLTransUpQry2 = "UPDATE TW_TRANS SET DEPT_RCPT_NO = '" + PayBean.getStrRecptNo() +"', " +
		        		" DEPT_RCPT_DT =TO_DATE('"+PayBean.getStrCurDate()+ "'," + "'DD-MM-YYYY')"  + 
						", REMOTE_UPDATE = 'Y',REMOTE_UPD_DATE=SYSDATE WHERE TW_TRAN_NO = '" + PayBean.getStrTransNo() +"'"; 
				 System.out.println(strLTransUpQry2);
		        		stmtObj.addBatch(strLTransUpQry2); 
		        		
		        		int[] count=stmtObj.executeBatch();
		        		if(count.length==3){
		        			conObj.commit();  
		        			ResponeBean.setStrResponeCode("000");
		        			ResponeBean.setStrResponeDesc("SUCCESS");
		        		}else{
		        			 conObj.rollback();
		        			 ResponeBean.setStrResponeCode("189");
			        		 ResponeBean.setStrResponeDesc("ROLLBACK");
		        		}
	           }catch(Exception e){
        		   conObj.rollback();
			       System.out.println(e.toString());
				   ResponeBean.setStrResponeCode("111");
				   ResponeBean.setStrResponeDesc("DATA BASE SHUT DOWN,PLEASE DO AFTER SOME TIME"+e.toString());
				   return ResponeBean;
			   }
			 
	            }catch(Exception e){
				       conObj.rollback();
				       System.out.println("-------"+e.toString());
					   ResponeBean.setStrResponeCode("101");
					   ResponeBean.setStrResponeDesc("DATA BASE SHUT DOWN,PLEASE DO AFTER SOME TIME");
					   return ResponeBean;
				 }
			
		}catch(Exception e){
			ResponeBean.setStrResponeCode("101");
			ResponeBean.setStrResponeDesc("DATA BASE SHUT DOWN,PLEASE DO AFTER SOME TIME");
			return ResponeBean;
		}finally{
        	try {
				if(rsObj !=null)
	        	{rsObj.close();}
        		if(stmtObj !=null)
	        	{stmtObj.close();}
        		if(conObj !=null)
	        	{conObj.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

		return ResponeBean;
		
	} 
}
