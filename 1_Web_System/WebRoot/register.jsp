<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#CED3FE">
  	<center>
  	
    Please Fill The Form<br><br>
    <form name="register_form" action="addUser" method="post" >
    	 
    	 <table >
    	 
    	 <tr><td>UserName</td><td><input type="text" name="username" ></td></tr>
    	 <tr><td>PassWord</td><td><input type="text" name="password"></td></tr>
    	 <tr><td>Age</td><td><input type="text" name="age"></td></tr>
    	
    	<td><br><button type="submit">Submit</button></td>
    	<td><br><button type="reset">Reset</button></td>
    </form>
    <tr><td>
    <form action="main.jsp">
    <button>Back</button></form></td></tr>
    </table>
    </center>
  </body>
</html>
