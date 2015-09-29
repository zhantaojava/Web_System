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
  
  <body>
    This is my JSP page. <br>
	
    <form ACTION="login.jsp">
<input type="checkbox" name="id" value="Java"> Java<BR>
<input type="checkbox" name="id" value=".NET"> .NET<BR>
${webFrameworkList}<br>
<input type="checkbox" name="id" value="PHP"> PHP<BR>
<input type="checkbox" name="id" value="C/C++"> C/C++<BR>
<input type="checkbox" name="id" value="PERL"> PERL <BR>
<input type="submit" value="Submit">


   
</form>
<br>
<form action="loginValidation" method="post">
  UserName:<input type="text" name="username"><br>
    PassWord:<input type="text" name="password"><br>
<input type="submit" value="Submit">

</form>
    
    ${kj }
    ${message }
  </body>
</html>
