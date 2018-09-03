<%@page import="cab.db.DBCon"%>
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
		String procedure = "{call findall()}";
		DBCon dbc = new DBCon();
		ResultSet rs = dbc.doQuery(procedure, new Object[] {});
	%>
	<table>
		<%
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("id")%></td>
			<td><%=rs.getString("username")%></td>
			<td><%=rs.getString("password")%></td>
			<td><a href="call_delete.jsp?id=<%=rs.getInt("id")%>">Delete</a></td>
			<td><a href="call_edit.jsp?id=<%=rs.getInt("id")%>">Edit</a></td>
		</tr>
		<%
			}
			dbc.close();
		%>
	</table>
	<a href="addAdmin.jsp">添加用户</a>
</body>
</html>