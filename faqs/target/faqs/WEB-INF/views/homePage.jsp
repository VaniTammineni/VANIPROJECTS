<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/jquery.dataTables.css">
<script src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.js"></script>
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/cuf_run.js"></script>
<script>
// $(document).ready(function(){
// 	alert("hai");
// 	var list=${totalList};
// 	$.each([list], function() {
// 		  alert( $(this).text() );
// 		});
	
// });
</script>

<script >
$(document).ready(function() {
	
	  $('#dtBasicExample').DataTable();
// 	  $('.dataTables_length').addClass('bs-select');
	});

</script>
<script>
function myfun(){
	var x = document.getElementById('dtBasicExample');
	 
if (x.style.display === "none") {
x.style.display = "block";
} else {
x.style.display = "none";
}
	
}
</script>
 <script>
/* $( function() {
	$(".abcd").click(function(){
		alert($(this).text());
		var qstn = $(this).text();
		$.ajax({
    	    type : "GET",
    	    url : "questions.html",
    	    data : {
    	    	qstn : qstn
    	    	
    	    	},
    	       // contentType: "application/json; charset=utf-8",
    	    	 dataType : "json",
    	    	
    	    	success: function (response) {
    	    		
    	    		$('#result').html("");
                    var obj = JSON.parse(response);
                    $('#result').html(obj.editor); 
    	            alert("data is:"+response);
    	        }
    	    }); 
		
	});
    	});
 */    </script>

<script>
   function funGeAnswar(qustnId,divId){
	   alert(qustnId);
	   	
	   var queryStr="qstn="+qustnId;
	  
	   $.ajax({
   	    type : "GET",
   	    url : "questions.html",
   	    data : {
   	    	qstn : qustnId
   	    	
   	    	}, 
   	       // contentType: "application/json; charset=utf-8",
   	    	 dataType : "json",
   	    	
   	    	success: function (response) {
   	    		 alert("data is:"+response);
//    	    		 $('#result').html(""); 
   	    		
   	    		var obj=JSON.stringify(response);
   	    		alert("object is:" +obj);
   	    		var foo=response.editor;
   	    		//alert(foo);
   	    		var str = '';
   	    		
   	    		for (var i=0; i<foo.length; ++i) {
   	    		  str+= String.fromCharCode(foo[i]);
   	    		}
   	    		 var otherElement = $('<h5 style=color:blue>Ans:</h5><img src="data:image/png;base64,' + str + '">');
                   $('#result'+divId).append(otherElement); 
   	           
   	        }
   	    }); 
   }
   
// $( function() {
// 	$(".btn").click(function(){
// 		for(var i=0;i<3;i++){
// 		$(".btn")[i].setAttribute("id", "democlass"+i);
// 		}
// 		alert($(this).text());
// 		var qstn = $(this).text();
// 		$.ajax({
//     	    type : "GET",
//     	    url : "questions.html",
//     	    data : {
//     	    	qstn : qstn
    	    	
//     	    	}, 
//     	       // contentType: "application/json; charset=utf-8",
//     	    	 dataType : "json",
    	    	
//     	    	success: function (response) {
//     	    		 alert("data is:"+response);
// //     	    		 $('#result').html(""); 
    	    		
//     	    		var obj=JSON.stringify(response);
//     	    		alert("object is:" +obj);
//     	    		var foo=response.editor;
//     	    		//alert(foo);
//     	    		var str = '';
    	    		
//     	    		for (var i=0; i<foo.length; ++i) {
//     	    		  str+= String.fromCharCode(foo[i]);
//     	    		}
//     	    		 var otherElement = $('<div>' +str+'</div>');
//                     $('.navigation').append(otherElement); 
    	           
//     	        }
//     	    }); 
		
// 	});
//     	});
    </script>

<script>
  
  function linuxGeAnswar(qustnId,divId){
	   	
	   var queryStr="qstn="+qustnId;
	  
	   $.ajax({
  	    type : "GET",
  	    url : "linuxqutions.html",
  	    data : {
  	    	qstn : qustnId
  	    	
  	    	}, 
  	       // contentType: "application/json; charset=utf-8",
  	    	 dataType : "json",
  	    	
  	    	success: function (response) {
  	    		 alert("data is:"+response);
//   	    		 $('#result').html(""); 
  	    		
  	    		var obj=JSON.stringify(response);
  	    		alert("object is:" +obj);
  	    		var foo = response.lQuestion;
  	    		alert(foo.length);
  	    		alert(foo);
  	    		var str = '';
  	    		
  	    		for (var i=0; i<foo.length; ++i) {
  	    		  str+= String.fromCharCode(foo[i]);
  	    		  alert(str);
  	    		}
  	    		 var otherElement = $('<h5 style=color:blue>Ans:</h5><div id="myDiv1" style="align:right;border:solid white;background-color:#e0e0e0;text-align:center;">' +str+'</div>');
                  $('#linuxresult'+divId).append(otherElement); 
  	           
  	        }
  	    }); 
  }
  
  </script>
  <script>
  
  function unixGeAnswar(qustnId,divId){
	   	
	   var queryStr="qstn="+qustnId;
	  
	   $.ajax({
  	    type : "GET",
  	    url : "unixqutions.html",
  	    data : {
  	    	qstn : qustnId
  	    	
  	    	}, 
  	       // contentType: "application/json; charset=utf-8",
  	    	 dataType : "json",
  	    	
  	    	success: function (response) {
  	    		 alert("data is:"+response);
//   	    		 $('#result').html(""); 
  	    		
  	    		var obj=JSON.stringify(response);
  	    		alert("object is:" +obj);
  	    		var foo=response.uQuestion;
  	    		//alert(foo);
  	    		var str = '';
  	    		
  	    		for (var i=0; i<foo.length; ++i) {
  	    		  str+= String.fromCharCode(foo[i]);
  	    		}
  	    		 var otherElement = $('<h5 style=color:blue>Ans:</h5><div id="myDiv2" style="align:right;border:solid white;background-color:#e0e0e0;text-align:center;">' +str+'</div>');
                  $('#unixresult'+divId).append(otherElement); 
  	           
  	        }
  	    }); 
  }
  
  </script>
 
<!-- <script>
$(document).ready(function(){
	$(".abc").click(function(){
		alert($(".abc").text());
	});
});
</script> -->

<script>
//working
/*  $( function(){
	$(".abcd").click(function(){
		alert($(this).text());
		var qstn = $(this).text();
	} );	
	}); */
 
//     $('.navigation').find('.abcd').each(function(i){
//         var $this = $(this);
//         $this.attr('href','#'+i); 
//         $this.attr('href','#'+i).click(function(){
//         	 alert( $this.attr('href','#'+i).text());
//         	var qustn=  $this.attr('href','#'+i).text();
//         })
//         //alert( $this.attr('href','#'+i).text());// this will return from #0 you can this with '#'+i+1
//     });



</script>




<style type="text/css">
/* #dtBasicExample{ */
/* position:relative; */
/* left:15px; */
/* right:1500px; */
/* top:6px} */

table{
position:relative;
left:15px;
right:1500px;
top:6px} 
.header {
	background: url(<%=request.getContextPath()%>/resources/images/header_bg.gif) repeat-x top;
}
.menu_nav {
	float: right;
	width: 653px;
	height: 46px;
	background: url(<%=request.getContextPath()%>/resources/images/menu_bg.jpg) no-repeat center top;
}
.menu_nav ul li a:hover, .menu_nav ul li.active a {
	color: #74a035;
	background: url(<%=request.getContextPath()%>/resources/images/menu_a.gif) repeat-x top;
	border-radius: 4px;
/* 	-moz-border-radius: 4px; */
/* 	-webkit-border-radius: 4px; */
}
.hbg {
	height: 75px;
	background: url(<%=request.getContextPath()%>/resources/images/hbg_bg.gif) repeat-x top;
	overflow: hidden;
	color: #fff;
}
ul.sb_menu li, ul.ex_menu li {
	margin: 0;
	background: url(<%=request.getContextPath()%>/resources/images/li.gif) no-repeat 0 12px;
}
div pgraph{
border:1px solid black;}


</style>
</head>
<body>
	<div class="header">
		<div class="header_resize">
			<div class="menu_nav">
				<ul>
					<li class="active"><a href="index.html">Home</a></li>
					<!--<li><a href="support.html">Support</a></li>
          <li><a href="about.html">About Us</a></li>
          <li><a href="blog.html">Blog</a></li>
          <li><a href="contact.html">Contact Us</a></li>-->
				</ul>
			</div>
			<!-- <div class="clr"></div>
			<div class="logo">
				<h1 align="right">
					<a href="index.html"><span>TRS</span><br /> <small>FAQ's</small></a>
				</h1>
			</div> -->

			<div class="clr"></div>
		</div>
	</div>
	<div class="hbg">
		<div align="center">
		<a align="right" href="login.htm"><h3>Login</h3></a>
			<!--<div class="hbg_resize">
      <img src="images/hbg_img.jpg" width="334" height="223" alt="img" class="hbgimg" />
      <h2>Read me first...</h2>
      <p><strong>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ac magna a turpis ornare aliquam id hendrerit nisl.</strong></p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ac magna a turpis ornare aliquam id hendrerit nisl. Pellentesque adipiscing blandit mollis. Curabitur varius est et sem rhoncus et pretium massa molestie.</p>
      <a href="#"><img src="images/readmore.jpg" width="115" height="33" alt="read more" border="0" /></a>
    </div>-->
		</div>
	</div>
	<div>
<!-- 	<a href="#">Java FAQ's</a></div> -->
	<div class="content">
		<div class="content_resize">
			<div class="clr">
			<p><strong>JAVA FAQ'S</strong>
</p>			<div>
			<div class="navigation" >
			   <c:forEach items="${totalList}" var="list" varStatus="count">
	
			   <span><strong>Q:</strong></span>
			   <button class="btn" onclick="funGeAnswar(${list.qustnId},${count.count})" style="width:75%;text-align:left">${list.getQuestion().toString()}</button><span id="name" style="color:#0000EE;"> ?</span>
<%-- 			
   <a href="questions.html" class="abcd">${list.getQuestion().toString()}</a><span style="color:#0000EE;"> ?</span> --%>
			  <div>
<!-- 			  <span><strong>A:</strong></span> -->
			   <div class="pgraph" id="result${count.count}" style="width:75%;" name="result${count.count}"></div>
			   </div>
			   <br>
			   </c:forEach>
			
			</div>
			</div>

<p><strong>Linux FAQ'S</strong></p>
<div>
			<div class="linuxnavigation" >
			   <c:forEach items="${linuxList}" var="linlist" varStatus="count">
	
			   <span><strong>Q:</strong></span>
			   <button class="btn" onclick="linuxGeAnswar(${linlist.lqustnId},${count.count})" style="width:75%;text-align:left">${linlist.lQuestion}</button><span id="name" style="color:#0000EE;"> ?</span>
<%-- 			
   <a href="questions.html" class="abcd">${list.getQuestion().toString()}</a><span style="color:#0000EE;"> ?</span> --%>
			  <div>
<!-- 			  <span><strong>A:</strong></span> -->
			   <div class="lgraph" id="linuxresult${count.count}" style="width:75%;" name="linuxresult${count.count}"></div>
			   </div>
			   <br>
			   </c:forEach>
			
			</div>
			</div>

<p><strong>Unix FAQ'S</strong></p>
<div>
			<div class="unixnavigation" >
			   <c:forEach items="${unixList}" var="unlist" varStatus="count">
	
			   <span><strong>Q:</strong></span>
			   <button class="btn" onclick="unixGeAnswar(${unlist.uqustnId},${count.count})" style="width:75%;text-align:left">${unlist.uQuestion}</button><span id="name" style="color:#0000EE;"> ?</span>
<%-- 			
   <a href="questions.html" class="abcd">${list.getQuestion().toString()}</a><span style="color:#0000EE;"> ?</span> --%>
			  <div>
<!-- 			  <span><strong>A:</strong></span> -->
			   <div class="ugraph" id="unixresult${count.count}" style="width:75%;" name="unixresult${count.count}"></div>
			   </div>
			   <br>
			   </c:forEach>
			
			</div>
			</div>


					<p>
						<strong>
							<button type="button" class="btn btn-link" style="color: blue"
								onclick="myfun()">JAVA FAQ'S</button>
						</strong>
					</p>

					<table id="dtBasicExample"
						class="table table-bordered position-absolute" cellspacing="0"
						width="100%">
						<thead>
							<tr style="background-color: #99ccff;">
								<th class="th-sm" style="color: blue;">Question</th>
								<th class="th-sm" style="color: blue;">Answer</th>
							</tr>
						</thead>
						<tbody>

							<!--   <tr> -->
							<%--   <td>${qus}</td> --%>
							<%--   <td>${ans}</td> --%>
							<!--   </tr> -->

							<c:forEach items="${totalList}" var="list">
								<%--   <c:out value='${list.getEditor()}'>  </c:out> --%>
								<%--   <% byte[]  s= list.getEditor(); --%>
								<%--  String q =  new String(s);%> --%>


								<tr>

									<td>${list.getQuestion().toString()}</td>
									<%--    // <%System.out.printlnlist.getQuestion()); %> --%>
									<td>${list.getEditor().toString()}</td>


								</tr>
							</c:forEach>

						</tbody>
						<tfoot>
						</tfoot>

					</table>
					<p>
					<strong>  Windows FAQ'S:</strong>
				</p>
				<table   width="885" height="144" border="1">
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0001</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0002</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0003</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0004</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0005</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0006</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0007</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0008</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0009</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0010</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
				</table>
				<p>&nbsp;</p>
				<p>
					<strong>  Linux FAQ's:</strong>
				</p>
				<table width="885" height="144" border="1">
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0001</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0002</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0003</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0004</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0005</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0006</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0007</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0008</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0009</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0010</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
				</table>
				<p>&nbsp;</p>
				<p>
					<strong>  CISCO FAQ's:</strong>
				</p>
				<table width="885" height="144" border="1">
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0001</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0002</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0003</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0004</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0005</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0006</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0007</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0008</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0009</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0010</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
				</table>
				<p></p>
				<p></p>
				<p>
					<strong>  Juniper FAQ's:</strong>
				</p>
				<table width="885" height="144" border="1">
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0001</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0002</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0003</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0004</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0005</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0006</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0007</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0008</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0009</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
					<tr>
						<td width="59" height="26"><div align="center">
								<span class="style1">0010</span>
							</div></td>
						<td height="26"><div align="left">
								<span class="style1"><a href="faq.html">
										0000000000000000 </a></span>
							</div></td>
					</tr>
				</table>
				<p></p>
			</div>
		</div>
	</div>

	<div class="fbg">
		<div class="fbg_resize">
			<div class="clr"></div>
		</div>
	</div>
	<div class="footer">
		<div class="footer_resize"></div>
	</div>
	</div>
	<script type="text/javascript">
$(document).ready(function() {
	  $('#dtBasicExample').DataTable();
	  $('.dataTables_length').addClass('bs-select');
	});

</script>
<!-- <input type="hidden" id="hdnqustn" name="hdnqustn"> -->

</body>
</html>