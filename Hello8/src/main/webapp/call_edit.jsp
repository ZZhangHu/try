<%@page import="java.sql.ResultSet"%>
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
		String procedure = "{call finById(?)}";
		DBCon dbc = new DBCon();
		ResultSet rs = dbc.doQuery(procedure, new Object[] { id });
		if (rs.next()) {
	%>
	<form action="call_update.jsp" method="post">
		<input type="hidden" name="id" value="<%=rs.getInt("id")%>"> 
		<input type="text" name="username" value="<%=rs.getString("username")%>">
		<input type="text" name="password" value="<%=rs.getString("password")%>"> 
		<input type="submit" value="Update">
	</form>
	<%
		}
		dbc.close();
	%>
</body>
</html>