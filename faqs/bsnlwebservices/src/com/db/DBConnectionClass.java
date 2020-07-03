package com.db;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionClass {

	public static Connection getConnection(){	
		Connection conObj=null;
		Properties props=new Properties();
		try{
			props.load(new FileInputStream("D://wsconf/ConnectionParams.properties"));
        	String strUrl="",strUser="",strPass="";
        	strUrl=props.getProperty("host");
            strUser=props.getProperty("user");
            strPass=props.getProperty("pass");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conObj=DriverManager.getConnection("jdbc:oracle:thin:"+strUrl,strUser,strPass);
			conObj.setAutoCommit(false);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conObj;
	}
}
