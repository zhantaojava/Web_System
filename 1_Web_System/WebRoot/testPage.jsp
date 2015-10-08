<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testPage.jsp' starting page</title>
    
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
    int binding <br>
	<form action="test1">
	Int:<input name="count">
	<input type="submit" value="submit">
	</form>
	    
    
    
    Model Binding & @RequestParam
    <form action="test2" >
    Name:<input name="name">
    Age:<input name="aage">
    <input type="submit" value="submit">
    
    </form>
    
    
    
    ModelAtrribute Binding
    
    <form name="u"  action="test3"  >
    Name:<input name="uname">
    Age:<input name="myage">
    <input type="submit" value="submit">
    
    </form>
    
    
  </body>
</html>
