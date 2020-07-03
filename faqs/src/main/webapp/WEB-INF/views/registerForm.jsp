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
<link href="<%=request.getContextPath() %>/resources/css/daterangepicker.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/select2.min.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css/main.css" rel="stylesheet" media="all">
<link href="<%=request.getContextPath() %>/resources/css1/ionicons.min.css" rel="stylesheet" media="all">

 <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
 <script>
/*  $(document).ready(function () {

	    $('#userform').validate({ // initialize the plugin
	        rules: {
	        	firstName: {
	                required: true,
	                email: true
	            },
	            lastName: {
	                required: true,
	                minlength: 5
	            }
	        },
	        submitHandler: function (form) { // for demo
	            alert('valid form submitted'); // for demo
	            return false; // for demo
	        }
	    });

	}); */
 </script>
 <style type="text/css">
button { 
 	position: relative; 
/* left: 70px; */
	top: 6px; 
/* 	 height: 45px; */
/* 	 width:20px; */
#activeType {
  float: right;
  clear: both;
}
#userType{
  float: left;
  clear: both;
}
</style>
 <script>
//  debugger;

 $(document).ready(function(){
	  $("#firstName").blur(function(){
	 
		        var name = $(this).val();
				var fnamelength = name.length;
				var letters = /^[A-Za-z]+$/;

				var errorname = $("#error-firstName");

				if (name == '' || name == null) {
					errorname.text("First Name Not To Be Empty");
					// alert("name not to be empty");
					return false;
				}

				else if (!(name.match(letters))) {
					errorname.text("Allow Only Alphabets");
					return false;
				} else if (fnamelength<=1 || fnamelength>30) {
					errorname.text("Length To Above 1 And Below 30");
					return false;
				} else {
					errorname.html('');
				}
			});
		});
	</script>
	<script>
	$(document).ready(function(){
		  $("#lastName").blur(function(){
		 
			        var lname = $(this).val();
					var lnamelength = lname.length;
					var letters1 = /^[A-Za-z]+$/;

					var errorlname = $("#error-lastName");

					if (lname == '' || lname == null) {
						errorlname.text("Last Name Not To Be Empty");
						// alert("name not to be empty");
						return false;
					}

					else if (!(lname.match(letters1))) {
						errorlname.text("Allow Only Alphabets");
						return false;
					} else if (lnamelength<=1 || lnamelength>30) {
						errorlname.text("Length To Above 1 And Below 30");
						return false;
					} else {
						errorlname.html('');
					}
				});
			});
	</script>
	<script>
	$(document).ready(function(){
		  $("#uname").blur(function(){
		 
			        var uname = $(this).val();
					var unamelength = uname.length;
					var letters2 = /^[A-Za-z]+$/;

					var erroruname = $("#error-uname");

					if (uname == '' || uname == null) {
						erroruname.text("User Name Not To Be Empty");
						// alert("name not to be empty");
						return false;
					}

					else if (!(uname.match(letters2))) {
						erroruname.text("Allow Only Alphabets");
						return false;
					} else if (unamelength<=1 || unamelength>21) {
						erroruname.text("Max Length  To Be 20");
						return false;
					} else {
						erroruname.html('');
					}
				});
			});
	</script>
	<script>
	$(document).ready(function(){
		  $("#pass").blur(function(){
		 
			        var pwd = $(this).val();
					var pwdlength = pwd.length;
					 // var pwdexp = ' /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{4,15}$/';
					 

					var errorpwd = $("#error-pass");

					if (pwd == '' || pwd == null) {
						errorpwd.text("Password Not To Be Empty");
						// alert("name not to be empty");
						return false;
					}
					/* if(!pwd.match(pwdexp)){
						errorpwd.text("PASSWORD SHOULD CONTAIN ATLEAST ONE NUMERIC AND A SPECIAL CHARACTER");
						return false;
						} */
					

					 /*  else if (!(pwd.match(pwdexp))) {
						errorpwd.text("PASSWORD SHOULD CONTAIN ATLEAST ONE NUMERIC AND A SPECIAL CHARACTER");
						return false;
					} */ else if (pwdlength<=1 || pwdlength>16) {
						errorpwd.text("Max Length To Be 15");
						return false;
					} else {
						errorpwd.html('');
					}
				});
			});
	</script>
	<script>
	$(document).ready(function(){
		  $("#mobileNo").blur(function(){
		 
			        var mob = $(this).val();
					var moblength = mob.length;
					var mobexp = /^\d{10}$/;
					 // var mobexp = '/^[a-z0-9]';

					var errormob = $("#error-mobileNo");

					if (mob == '') {
						errormob.text("Mobile NO Not To Be Empty");
						// alert("name not to be empty");
						return false;
					}
					else if (!mobexp.test(mob)){
						   
						errormob.text("Max Length To Be 10 && Allows Only Numbers");
						  } 
					
					else if(mob.charAt(0)!=6 && mob.charAt(0)!=7 && mob.charAt(0)!=8 && mob.charAt(0)!=9){
						errormob.text("Number Start With 6 or 7 or 8 or 9");
						}
					else {
						errormob.html('');
					}
				});
			});
	</script>
	<script>
	$(document).ready(function(){
		  $("#email").blur(function(){
		 
			        var email = $(this).val();
					var emaillength = email.length;
					  var emailexp = '/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/';

					var erroremail= $("#error-email");

					if (email == '' || email == null) {
						erroremail.text("Email Id  Not To Be Empty");
						// alert("name not to be empty");
						return false;
					}
				   else {
						erroremail.html('');
					}
					if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))
					   {
						    
					   } else  {
						   erroremail.text("Enter A Valid Email");
						  return false;}

					 
					if (emaillength<=1 || emaillength>30) {
						erroremail.text("Max Length To Be Above 1 ");
						return false;
					} else {
						erroremail.html('');
					}
				});
			});
	</script>
	<script>
	$(document).ready(function(){
		  $("#userid").blur(function(){
		 
			        var userid = $(this).val();
			        var erroruserid= $("#error-userid");

					if (userid == '' || userid == null) {
						erroruserid.text("User Id  Not To Be Empty");
						// alert("name not to be empty");
						return false;
					}
					else {
						erroruserid.html('');
					}
				});
			});
	</script>
	
	
	<script>
	$(document).ready(function(){
		  $("#pincode").blur(function(){
		 
			        var pincode = $(this).val();
					var pincodelength = pincode.length;
					var errorpincode = $("#error-pincode");
					var pat1=/^\d{6}$/;;
						 if (!(pat1.test(pincode)))  {
							 errorpincode.text("PIN Must Be 6 Digits");
				       
				         return false;
				     }else {
				    	 errorpincode.html('');
						}
					     

		  });
	});
	</script>
	<script>
	$(document).ready(function(){
		  $("#state").blur(function(){
		 
			        var state = $(this).val();
			        var errorstate= $("#error-state");

					if (state == '' || state == null) {
						errorstate.text("Email Id  Not To Be Empty");
						// alert("name not to be empty");
						return false;
					}
					else {
						errorstate.html('');
					}
				});
			});
	</script>
	
	<script>
	$(document).ready(function(){
		  $("#state").blur(function(){
		 
			        var state = $(this).val();
			        var errorstate= $("#error-state");

					if (state == '' || state == null) {
						errorstate.text("State  Not To Be Empty");
						// alert("name not to be empty");
						return false;
					}
					else {
						errorstate.html('');
					}
				});
			});
	</script>
	<script>
	$(document).ready(function(){
		  $("#country").blur(function(){
		 
			        var country = $(this).val();
			        var errorcountry= $("#error-country");

					if (country == '' || country == null) {
						errorcountry.text("Country  Not To Be Empty");
						// alert("name not to be empty");
						return false;
					}
					else {
						errorcountry.html('');
					}
				});
			});
	</script>
	
 <script>
 function fun(){
	 var password = document.getElementById("pass").value;
		
		if (password == "" || password == null) {
			alert("password field not to be empty");
			return false;
		}

		var txt_string = document.getElementById('pass').value;
		 var enc = window.btoa(txt_string);

		 // alert("Encoded String: " + enc);
		

		document.getElementById('pass').value = SHA256(enc);
// 	 var pwdencode= $("#pass").val();
// 	 var enc = window.btoa(pwdencode);

// 	  alert("Encoded String: " + enc);
	 /* var fname=$("#firstName").val();
	 var userid= $("#userid").val();
	 var lname=$("#lastName").val();
	 var uname=$("#uname").val();
	 var pass=$("#pass").val();
	 var email=$("#email").val();
	 var address1=$("#address1").val();
	 var address2=$("#address2").val();
	 var mobno=$("#mobileNo").val();
	 var landno=$("#landLineNo").val();
	 var state=$("#state").val();
	 var country=$("#country").val(); */

	/*  if((fname == '' || fname == null)){
 		 alert("First Name not empty");
		 return false;
		 }
	 if((lname == '' || lname == null)){
 		 alert("Last Name not empty");
		 return false;}
	 
	 if((uname == '' || uname == null)){
 		 alert("User Name not empty");
		 return false;}
	 if((pass == '' || pass == null)){
 		 alert("Password not empty");
		 return false;}
	 if((email == '' || email == null)){
 		 alert("Email Not To Be  Empty");
		 return false;}
	 if((userid == '' || userid == null)){
 		 alert("Email Not To Be  Empty");
		 return false;
		 } */
	 

	 var e = document.getElementById("userType");
        var optionSelIndex = e.options[e.selectedIndex].value;
        var optionSelectedText = e.options[e.selectedIndex].text;
        if (optionSelIndex == "") {
            alert("Please select a UserType");
            return false;
        }

        var e1 = document.getElementById("activeType");
        var optionSelIndex1 = e1.options[e1.selectedIndex].value;
        var optionSelectedTex1t = e1.options[e1.selectedIndex].text;
        if (optionSelIndex1 == "") {
            alert("Please select an Active Type");
            return false;
        }
       
        document.userform.method = "POST";	   
	 document.userform.action = "welcome.htm";
	 document.userform.submit();
 }
 
 </script>

</head>
<body>
<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title" align="center">Registration Form</h2>
                    <form:form  id="userform" name="userform" modelAttribute="userform">
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <form:label path="firstName" required="required">First Name</form:label>
                                    <form:input class="input--style-4"  path="firstName" />
                                    <span style="color:red" id="error-firstName"></span>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label path="lastName">Last Name</label>
                                    <form:input class="input--style-4" path="lastName" />
                                      <span style="color:red" id="error-lastName"></span>
                                </div>
                            </div>
                        </div>
                         <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label path="uname">User Name</label>
                                    <form:input class="input--style-4" path="uname" />
                                    <span style="color:red" id="error-uname"></span>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label path="pass">Password</label>
                                    <form:password class="input--style-4" path="pass" />
                                    <span  style="color:red" id="error-pass"></span>
                                </div>
                            </div>
                        </div>
                         <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label path="mobileNo">Mob No</label>
                                    <form:input class="input--style-4" path="mobileNo" />
                                    <span style="color:red" id="error-mobileNo"></span>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label path="landLineNo">Landline Number</label>
                                    <form:input class="input--style-4" path="landLineNo" />
                                    <span style="color:red" id="error-landLineNo"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label path="email">Email</label>
                                    <div class="input-group-icon">
                                        <form:input class="input--style-4"  path="email" />
                                        <span style="color:red" id="error-email"></span>
                                      
                                    </div>
                                </div>
                                
                                  <div class="col-2">
                                <div class="input-group">
                                    <label path="email">User ID</label>
                                    <div class="input-group-icon">
                                        <form:input class="input--style-4"  path="userid" />
                                        <span style="color:red" id="error-userid"></span>
                                      
                                    </div>
                                </div>
                                
                            </div>
                           <!--  <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Gender</label>
                                    <div class="p-t-10">
                                        <label class="radio-container m-r-45">Male
                                            <input type="radio" checked="checked" id="" name="gender">
                                            <span class="checkmark"></span>
                                        </label>
                                        <label class="radio-container">Female
                                            <input type="radio" name="gender" id="">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                </div>
                            </div> -->
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label path="address1">Address1</label>
                                    <form:textarea class="input--style-4" rows="1" columns="10" path="address1" />
                                    <span style="color:red" id="error-address1"></span>
                                </div>
                           </div>
                           </div>
                           
                           <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label path="address2">Address2</label>
                                    <form:textarea class="input--style-4" rows="1" columns="10"  path="address2" />
                                    <span style="color:red" id="error-address2"></span>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label path="pincode">PIN Code</label>
                                    <form:input class="input--style-4" path="pincode"/>
                                    <span style="color:red" id="error-pincode"></span>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label path="state">State</label>
                                    <form:input class="input--style-4"  path="state" />
                                    <span style="color:red" id="error-state"></span>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label path="country">Country</label>
                                    <form:input class="input--style-4" path="country" />
                                    <span style="color:red" id="error-country"></span>
                                </div>
                            </div>
                        </div>
                        
<!--                         <div class="row row-space"> -->
                            
                            
<!--                         </div> -->
                        
<!--                         <div class="input-group"> -->
<!--                             <label class="label">State</label> -->
<!--                              <input class="input--style-4" type="text" name="phone"> -->
<!--                             <div class="rs-select2 js-select-simple select--no-search">
<!--                                 <select name="subject"> -->
<!--                                     <option disabled="disabled" selected="selected">Choose option</option> -->
<!--                                     <option>Subject 1</option> -->
<!--                                     <option>Subject 2</option> -->
<!--                                     <option>Subject 3</option> -->
<!--                                 </select> -->
<!--                                 <div class="select-dropdown"></div> -->
<!--                             </div> --> 
<!--                         </div> -->
                        
                         <div class="row row-space">
                            <div class="col-2">
                        <div class="input-group">
                            <form:label style="width:600%" path="userType">User Type</form:label>
<!--                              <input class="input--style-4" type="text" id="userType" name="userType"> -->
                           <div class="rs-select2 js-select-simple select--no-search" >
                                <form:select path="userType" >
                                    <form:option value="" >Select</form:option>
                                    <form:option value="Admin" >Admin</form:option>
                                    <form:option value="User" >User</form:option>
                                  
                                </form:select>
                                <span style="color:red" id="error-userType"></span>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                        </div>
                         <div class="col-2">
                        <div class="input-group">
                            <form:label style="width:600%" path="activeType"/>Active Type
<!--                              <input class="input--style-4" type="text" id="activeType" name="activeType"> -->
                           <div class="rs-select2 js-select-simple select--no-search" >
                                <form:select path="activeType" >
                                    <form:option  value="" >Select</form:option>
                                    <form:option value="Yes">Yes</form:option>
                                    <form:option value="No">No</form:option>
                                  
                                </form:select><span style="color:red" id="error-activeType"></span>
                                </div>
                                </div></div>
                                </div><br><br><br>
                        
                        <div class="p-t-15">
                            <button align="center" class="btn btn--radius-2 btn--blue" type="button" id="btnsubmit" onclick="fun()">Submit</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>


<script>
		document.getElementById('cryptstr').onclick = function() {
			
			var password = document.getElementById("pass").value;
			//var pwdexp = /^[a-z0-9]+$/i;
			if (password == "" || password == null) {
				alert("password field not to be empty");
				return false;
			}

			var txt_string = document.getElementById('pass').value;
			 var enc = window.btoa(txt_string);

			  alert("Encoded String: " + enc);
			

			document.getElementById('pass').value = SHA256(enc);
			//alert(document.getElementById('password').value);

			document.login.method = 'POST';
			document.login.action = "login.htm";
			document.login.submit();
			return true;

		}
	</script>
	
    <!-- Jquery JS-->
    <!-- <script src="vendor/jquery/jquery.min.js"></script>
    Vendor JS
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    Main JS
    <script src="js/global.js"></script> -->

</body>
</body>
</html>