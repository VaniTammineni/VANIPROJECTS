<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
<script src= "<%=request.getContextPath() %>/resources/js/shaalgorithm.js"> </script>

<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/roboto-font.css"> --%>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="<%=request.getContextPath() %>/resources/css/daterangepicker.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/select2.min.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/main.css" rel="stylesheet" media="all">

 <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

 
 <style type="text/css">
button { 
 	position: relative; 
    left: 150px; 
	top: 8px; 
/* 	 height: 45px; */
/* 	 width:20px; */
}
a#regstr { 
position: relative;
     color: #2da1c1; 
     font-size: medium; 
     text-decoration: none; 
     left: 150px;  
/*      float: right;  */
     top: 13px; 
} 

</style>
<script>

//$("#loginform").validate();
/* function fun(){
	
	var userName= $("#username").val();
	var cpwd = $("#password").val();
	if(userName=="" ||userName==null){
		alert("hello"+ " "+userName);
		return false;
		}
	document.loginform.method = "POST";
	document.loginform.action = "logincred.htm";
     document.loginform.submit();
	return true;
} */
</script>
 </head>
 <body>
<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title" align="center">Login Form</h2>
                    <form id="loginform"  name="loginform">
                    <table style="border-spacing: 0; border-width: 0; padding: 0; border-width: 0; cellpadding:0; cellspacing:0 border:0;">
                    <tr>
                    <td width="10">User Name</td>
                    <td width="0"><input type="text" class="input--style-4" id="username" name="username" required> <span style="color:red" id="error-username"></span></td>
                    </tr>
                     <tr>
                    <td width="10">Password</td>
                    <td  width="0"><input type="password" class="input--style-4" id="password" name="password" required></td>
                    </tr>
						<tr>
						<td align="center"><div class="col-s-10">
								<button type="button" class="btn btn-primary btn-sm" id="cryptstr"
									value="SignIn">Sign In</button><a id="regstr" href="register.htm" >New
								User</a>
							</div></td>
							</tr>
                    </table>
                          
<!--                                 <div > -->
<!--                                     <label align="center" for="username" >User Name</label> -->
<!--                                     <input class="input--style-4" align="center" width="30%" type="text" id="username" name="username" required/> -->
<!--                                     <span style="color:red" id="error-username"></span> -->
<!--                                 </div> -->
                            
                            <%-- <div class="col-2">
                                <div class="input-group">
                                    <label path="lastName">Last Name</label>
                                    <form:input class="input--style-4" path="lastName" />
                                      <span style="color:red" id="error-lastName"></span>
                                </div>
                            </div> --%>
                       
                         
<!--                                 <div> -->
<!--                                     <label float="right"for="password">Password</label> -->
<!--                                     <input class="input--style-4" float="left"  width="30%" type="text" id="password" name="password" required/> -->
<!--                                     <span style="color:red" id="error-password" ></span> -->
<!--                                 </div> -->
                         
                           <%--  <div class="col-2">
                                <div class="input-group">
                                    <label path="pass">Password</label>
                                    <form:input class="input--style-4" path="pass" />
                                    <span  style="color:red" id="error-pass"></span>
                                </div>
                            </div --%>
                       
                       <!--   <div class="p-t-15">
                            <button align="center" class="btn btn--radius-2 btn--blue" type="button" id="btnsubmit" onclick="fun()">Submit</button>
                                
                        </div>
                        <div>
                        <a href="register.htm" id="regstr">New User</a>
                        </div> -->
                        </form>
                        </div>
                        </div>
                        </div>
                        </div>
                        
                        	<script>
			document.getElementById('cryptstr').onclick = function() {
			//alert("hii");
			var password = document.getElementById("password").value;
			//var pwdexp = /^[a-z0-9]+$/i;
			if (password == "" || password == null) {
				alert("password field not to be empty");
				return false;
			}

			var txt_string = document.getElementById('password').value;
			 var enc = window.btoa(txt_string);
			 // alert("Encoded String: " + enc);
			  
			document.getElementById('password').value = SHA256(enc);

			document.loginform.method = "POST";
			document.loginform.action = "logincred.htm";
		     document.loginform.submit();
			return true;
		}
			</script>
</body>
</html>
                        