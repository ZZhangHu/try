<%@page import="cab.db.DBCon"%>
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
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		DBCon dbc = new DBCon();
		String procedure = "{call updateAdmin(?,?,?)}";
		int res = dbc.doUpdate(procedure, new Object[] { id, username,
				password });
		if (res > 0)
			response.sendRedirect("call_query.jsp");
		else
			out.println("更新失败");
	%>
</body>
</html>