<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'helloworld.jsp' starting page</title>
    
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
   
   <center>  Spring Test <br>
   <form action="login" method="post">
    UserName:<input type="text" name="username"><br>
    PassWord:<input type="text" name="password"><br>
    <input type="submit"value="Submit">
    <input type="reset"value="Reset">
   </form>
   <form action="register.jsp">
     	<button type="submit">Register</button>
     	</form>
   <br><br>
   ${ErrorMessage }
    </center>
     
    
  </body>
</html>
