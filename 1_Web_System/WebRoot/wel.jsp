<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'wel.jsp' starting page</title>
    
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
  <center>    
  Welcome <br>
    
    <%
    HttpSession hs=request.getSession();
    String username=(String)hs.getAttribute("user");
    
    if(username!=null){
    	out.println("Welcome you: "+username);
    }
    
    
    %><br>
    
    ${statue }<br><br>
    
    Username:${username }<br>
    
    Age:${age }<br>
    <br>
    <a href="/1_Web_System/login.jsp">Back</a>
    
    
     </center>
     
  </body>
</html>
