<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<%-- <%@ page import = "jared.simpledatabase.* %> --%>

<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/forge/0.8.2/forge.all.min.js"></script>

<!-- <meta charset="utf-8"> -->
<title>Login Form</title>
<!-- Mobile Specific Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- Font-->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="<c:url value="/resources/jquery/hash.js" />"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/roboto-font.css">
<link href="<%=request.getContextPath() %>/resources/css/daterangepicker.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/select2.min.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/main.css" rel="stylesheet" media="all">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/roboto-font.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />

<style type="text/css">
 button { 
 	position: relative; 
left: 150px;
	top: 10px; 
 } 
 a#regstr { 
position: relative;
     color: #2da1c1; 
     font-size: medium; 
     text-decoration: none; 
     left: 160px; 
     float: right; 
     top: 13px; 
} 
</style>
</head>
<body>
<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                                <form id="login" name="login" >
                                <table align="center">
                                <tr>
                                <td><label>User Name</label></td>
                                <td><input type="text" id="username" name="username"></td>
                                </tr>
                                
                                 <tr>
                                <td><label>Password</label></td>
                                <td><input type="password" id="password" name="password"></td>
                                </tr>
                                
                                 <tr>
                              
                                <td colspan="2"><input type="button" id="btnsubmit" name="btnsubmit" value="Sign In"><a href="register.htm" >New User</td>
                                </tr>
                                </table>
                                 <!-- <div >
<!--                             <div class="col-4"> -->
                              <!--   <div class="input-group">
                                 
                                    <label class="label" align="left">first name</label>
                                    <input align="right" class="input--style-4" type="text" name="first_name">
                                </div>
                            </div>
                            <div class="col-1">
                                <div class="input-group">
                                    <label class="label">last name</label>
                                    <input class="input--style-4" type="text" name="last_name">
                                
                                </div>
                                </div>
                                </div>
                                <div ><button type="button" class="btn btn-primary" id="cryptstr"
									value="SignIn">Sign In</button><a id="regstr" href="register.htm">New
								User</a>
                                </div> -->
                                
<%-- 			<form:form class="form-detail" id="login" name="login" --%>
				<%-- 
				<div align="center" style="color: red; width: '2000px';">${invalidpwd}</div>
				<form:errors path="*" cssClass="errorblock" element="div" />
				<h1 align='center'>Login</h1>

				<table align="center" id="users">
					<tr>
						<td><label>User Name</label></td>
						<td><input type="text" id="username" name="username"></td>
						<td> <form:input path='username' name='username' id='username'
								maxlength="75" style="width:80%" /></td>
					</tr>
					<tr>
						<td><label>Password</label></td>
						<td><input type="text" id="username" name="username"></td>
						<td><form:password path='password' name='password'
								id='password' maxlength="75" style="width:80%" /> </td>
					</tr>
					<tr>
						<td align="center"><div class="col-s-12">
								<button type="button" class="btn btn-primary" id="cryptstr"
									value="SignIn">Sign In</button><a id="regstr" href="register.htm">New
								User</a>
							</div></td>
						<!-- 						<td colspan='2' align="center"><input type="button" name="login" id="login" class="register" value="SignIn" onclick="loginfun();"></td> -->

					</tr>
				</table> --%>
			</form>
<%-- 			</form:form> --%>
			</div>
			</div>
			</div>
			</div>
			
	<script>
		/* document.getElementById('cryptstr').onclick = function() {
			var username = document.getElementById("username").value;
			var letters = /^[A-Za-z]+$/;
			if (username == "" || username == null) {
				alert("User Name not to be empty");
				return false;
			}
			var uidLen = username.length;
			if (uidLen<=1 || uidLen>20) {
				alert("User Id  length to be above 1 and below 20");
				document.getElementById("username").focus();
				return false;
			}

			if (!(username.match(letters))) {
				alert("Allow Only Alphabets");
				return false;
			}
			var password = document.getElementById("password").value;
			var pwdexp = /^[a-z0-9]+$/i;
			if (password == "" || password == null) {
				alert("password field not to be empty");
				return false;
			}

			var txt_string = document.getElementById('password').value;

			document.getElementById('password').value = SHA256(txt_string);
			//alert(document.getElementById('password').value);
 */
			document.login.method = 'POST';
			document.login.action = "login.htm";
			document.login.submit();
			return true;

		}
	</script>


<%-- 	<jsp:include page="Footer.jsp" /> --%>
</body>