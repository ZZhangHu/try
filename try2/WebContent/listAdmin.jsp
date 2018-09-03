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
<table>
	<s:iterator value="pageBean.list" var="hello">
		<tr>
		<td><s:property value="#hello.id"/></td>
		<td><s:property value="#hello.username"/></td>
		<td><s:property value="#hello.password"/></td>
		</tr>
	</s:iterator>
		<tr>
			<td>总共：<s:property value="pageBean.allRow" />条记录</td>
			<td>共:<s:property value="pageBean.totalPage"/>页</td>
			<td>当前第<s:property value="pageBean.currentPage"/>页</td>
			<td>
			<s:if test="%{pageBean.currentPage==1}">第一页上一页
			</s:if><s:else>
			<a href="list.action?page=1">第一页</a>
			<a href="list.action?page=<s:property value="{%pageBean.currentPage-1}"/>">上一页</a>
			</s:else>
			</td>
			<td>
			<s:if test="%{pageBean.currentPage!=pageBean.totalPage}">
			<a href="list.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
			<a href="list.action?page=<s:property value="%{pageBean.totalPage}"/>">最后一页</a>
			</s:if>
			<s:else>
			下一页 最后一页
			</s:else>
			</td>
		</tr>
</table>
<a href="addAdmin.jsp">添加用户</a>
</body>
</html>