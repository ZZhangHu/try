<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="add" method="post">
<s:textfield name="admin.username" label="username"></s:textfield>
<s:textfield name="admin.password" label="password"></s:textfield>
<s:submit value="添加"></s:submit>
</s:form>
</body>
</html>