<%@ page language="java" import="java.util.*,dao.HibernateDao" pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <center>
  <body>
  Please Enter You UserName and PassWord<br>
  
<br>
<form action="loginValidation" method="post">
  UserName:<input type="text" name="username"><br><br>
    PassWord:<input type="text" name="password"><br><br>
<input type="submit" value="Submit">

</form>
    
    ${kj }
    ${message }
  </body>
  </center>
</html>
