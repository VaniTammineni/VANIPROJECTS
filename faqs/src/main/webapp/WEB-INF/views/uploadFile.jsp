<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	
	function fun() {
		document.getElementById("formid").action = "saveUploadedFile.htm";
		document.getElementById("formid").method = "post";
		document.getElementById("formid").submit();
	}

	function funTable() {
	
		$("#rtnsubmit").click(function() {
				var name = "vaninaidu";
			$.ajax({
				 type : "POST",
		    	    url : "getTable.htm?name="+name,
		    	    data:{
		    	    	name : name
		    	    },
		    	    success : function(response) {
					alert("hi");
					alert("data is:" + response);
				}
			});
			
		});
	}
</script>

</head>
<body>
	<form id="formid" enctype="multipart/form-data">
		<h2>Upload File Here:</h2>
		User Id<input type="text" name="userId" id="userId"> 
		<input type="file" id="file" name="file"> 
		<input type="button" id="btnsubmit" name="btnsubmit" value="Save" onclick="fun()"><br>
		<input type="button" id="rtnsubmit" name="rtnsubmit" value="Generate Table" onclick="funTable()">

	</form>
</body>
</html>