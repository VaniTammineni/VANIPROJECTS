<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

  <c:forEach items="${demo1}" var="obj">
<div><p>Q: ${obj.getQuestion()}?</p></div>
<div> <h5><span class="label label-primary">Answer</span></h5><p>${obj.getEditor()}</p></div>
</c:forEach>


</body>
</html>