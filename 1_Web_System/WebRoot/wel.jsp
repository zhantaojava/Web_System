<%@ page language="java" import="java.util.*,dao.HibernateDao,model.User" pageEncoding="US-ASCII"%>
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
    
    
    
    
    <%
			int pageSize = 3;
			int pageNow = 1; // default 1st Page
			int rowCount = 0;
			int pageCount = 0;

			//process pageNow
			//fetch user expert pagenow

			String s_pageNow = request.getParameter("pageNow");
			
			if (s_pageNow != null) {
				// pageNow not null
				pageNow = Integer.parseInt(s_pageNow);

			}

			HibernateDao hibernateDao = new HibernateDao();

			pageCount = hibernateDao.SearchPageCount(pageSize);
		%>

		
		<table border="1">
			<tr>
				<td>id</td>
				<td>name</td>
				<td>pw</td>
				<td>age</td>
				<td>date</td>
			</tr>
			<%
				
			%>

			<%
				ArrayList al = (ArrayList) hibernateDao.searchPage(pageNow,
						pageSize);
				for (int i = 0; i < al.size(); i++) {
					User user = (User) al.get(i);
			%>
			<tr>
				<td><%=user.getId()%></td>
				<td><%=user.getName()%></td>
				<td><%=user.getPw()%></td>
				<td><%=user.getAge()%></td>
				<td><%=user.getDate()%></td>
				<td>${userList.get(i).getName()}</td>
				<%
					}
				%>
			
		</table>

		<%
			for (int i = 1; i <= pageCount; i++) {

				out.println("<a href=wel.jsp?pageNow=" + i + ">[" + i + "]</a>");

			}
		%>
		<br>
		<br>
		<br>
		
		
		Spring MVC table:<br>
		<table border=2>
			<tr>
			<td>Name:</td>
			<td>Age:</td>
			<td>Date:</td>
			<td>Email:</td>
			<td>Setting:</td>
			</tr>
			
			<tr>
				<td>${userList.get(0).getName()}</td>
				<td>${userList.get(0).getAge()}</td>
				<td>${userList.get(0).getDate()}</td>
				<td>${userList.get(0).getEmail()}</td>
				<td><a href="${userList.get(0).getName()}/edit">Edit</a></td>
			</tr>
			<tr>
				<td>${userList.get(1).getName()}</td>
				<td>${userList.get(1).getAge()}</td>
				<td>${userList.get(1).getDate()}</td>
				<td>${userList.get(1).getEmail()}</td>
				<td><a href="${userList.get(1).getName()}/edit">Edit</a></td>
			</tr>
			<tr>
				<td>${userList.get(2).getName()}</td>
				<td>${userList.get(2).getAge()}</td>
				<td>${userList.get(2).getDate()}</td>
				<td>${userList.get(2).getEmail()}</td>
				<td><a href="${userList.get(2).getName()}/edit">Edit</a></td>
			</tr>
			
			
						
			
			
			
		</table>
		<%
			for (int i = 1; i <= pageCount; i++) {

				out.println("<a href=retrieveUser?pageNow=" + i + ">[" + i + "]</a>");

			}
		%>
		
		
		
		
		
		
		
		
     </center>
     
     
     <br>     <br>     <br>     <br>     <br>     <br>     <br>     <br>
     <form action="getUser">
    	Search User:<input type="text" name="username">
    	<input type="submit"value="submit">
     </form>
     <br><br><br>
     
    
     
  </body>
</html>
