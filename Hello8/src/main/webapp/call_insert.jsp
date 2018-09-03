<%@page import="cab.db.DBCon"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String username = new String(request.getParameter("username"));
		String password = new String(request.getParameter("password"));
		DBCon dbc=new DBCon();
		String procedure = "{call insert(?,?)}";
		int res =dbc.doUpdate(procedure,new Object[] {username,password});
		if (res > 0)
			response.sendRedirect("call_query.jsp");
		else
			out.println("添加失败");

		dbc.close();
	%>
</body>
</html>