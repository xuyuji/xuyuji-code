<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	table{
		border-collapse: collapse;
	}
	td{
		border:1px solid black;
		padding:5px;
	}
	tr:hover  {
		background: whitesmoke;
	}
	</style>
</head>
<body>
	<h1>JSP路径</h1>
    <table>
    	<tr>
    		<td>this.getClass().getClassLoader().getResource(".").getPath()</td>
    		<td><%=this.getClass().getClassLoader().getResource(".").getPath() %></td>
    	</tr>
    	<tr>
    		<td>new File(".").getAbsolutePath()</td><td><%=new File(".").getAbsolutePath() %></td>
    	</tr>
    	<tr>
    		<td>request.getSession().getServletContext().getRealPath("")</td>
    		<td><%=request.getSession().getServletContext().getRealPath("") %></td>
    	</tr>
    	<tr>
    		<td>request.getSession().getServletContext().getContextPath()</td>
    		<td><%=request.getSession().getServletContext().getContextPath() %></td>
    	</tr>
    	<tr>
    		<td>request.getRequestURL()</td><td><%=request.getRequestURL() %></td>
    	</tr>
    	<tr>
    		<td>request.getRequestURI()</td><td><%=request.getRequestURI() %></td>
    	</tr>
    	<tr>
    		<td>request.getScheme()</td><td><%=request.getScheme() %></td>
    	</tr>
    	<tr>
    		<td>request.getServerName()</td><td><%=request.getServerName() %></td>
    	</tr>
    	<tr>
    		<td>request.getServerPort()</td><td><%=request.getServerPort() %></td>
    	</tr>
    	<tr>
    		<td>request.getContextPath()</td><td><%=request.getContextPath() %></td>
    	</tr>
    	<tr>
    		<td>request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"</td>
    		<td><%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" %></td>
    	</tr>
    </table>
</body>
</html>