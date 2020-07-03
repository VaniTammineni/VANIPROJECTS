<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath() %>/resources/js/editor.js"> </script>
<script>
	/* function GetElementsStartingWith(tagName, subString) {
		var elements = document.getElementsByTagName(tagName);
		var result = [];
		for (var i = 0; i < elements.length; i++) {
			var element = elements[i];
			if (element.id
					&& element.id.substr(0, subString.length) == subString) {
				result.push(element);
			}
		}
		var arrDivs = result;
		alert("result is"+arrDivs);
		for (var i = 0; i < arrDivs.length; i++) {
			arrDivs[i].style.backgroundColor = "red";
		}
	} */

	/* $("btnsubmit").click(function() {
		alert("hi");
		var arrDivs = GetElementsStartingWith("div", "x");
		alert(arrDivs);
		for (var i = 0; i < arrDivs.length; i++) {
			arrDivs[i].style.backgroundColor = "red";
		}
	}); */
</script>
<script>

	$(document).ready(function() {
		$("#btnsubmit").click(function() {
			var elements = document.getElementsByTagName("div");
			var result = [];
			for (var i = 0; i < elements.length; i++) {
				var element = elements[i];

				if (element.id != null) {
					result.push(element);
				}
			}
			var arrDivs = result;
			alert("result is" + arrDivs);
			for (var i = 0; i < arrDivs.length; i++) {
				arrDivs[i].style.backgroundColor = "red";
			}

		});
	});
</script>
<script>
			$(document).ready(function() {
				$("#txtEditor").Editor();
			});
		</script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<link href="<%=request.getContextPath() %>/resources/css/editor.css" type="text/css" rel="stylesheet"/>
		<title>LineControl | v1.1.0</title>

</head>
<body>
<form action="neweditor.htm" method="post">
<div class="container-fluid">
			<div class="row">
				<h2 class="demo-text">LineControl Demo</h2>
				<div >
				<input type="text" id="question" name="question" placeholder="Enter Your Question" style="width:80%">
				</div>
				<div class="container">
					<div class="row">
						<div class="col-lg-12 nopadding" id="y">
							<textarea id="txtEditor"></textarea> 
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid footer">
			<p class="pull-right">&copy; Suyati Technologies <script>document.write(new Date().getFullYear())</script>. All rights reserved.</p>
		</div>
		<div>
		<button type="button" id="btnsubmit" name="btnsubmit" >Save</button>
		</div>
</form>
</body>
</html>