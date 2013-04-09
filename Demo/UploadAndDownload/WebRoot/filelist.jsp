<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="xuyuji.UploadServlet"%>
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
		border: 1px solid gray;
		padding: 5px;
		width:200px;
	}
	tr:HOVER {
		background:green
	}
}
</style>
</head>
<body>
	<table>
	<%
		String folderPath = UploadServlet.getFolderPath();
		File folder = new File(folderPath);
		File[] files = folder.listFiles();
		for(int i = 0; i < files.length; i++){
			File file = files[i];
			String fileName = file.getName();
			int seperate = fileName.indexOf("_");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	 %>
	 	<tr>
	 		<td><%=fileName.substring(seperate + 1) %></td>
	 		<td><%=sdf.format(new Date(Long.parseLong(fileName.substring(0, seperate)))) %></td>
	 		<td style="width:60px;text-align:center"><a href="/UploadAndDownload/servlet/download?filePath=<%=file.getAbsolutePath() %>"><img src="img/download.gif"></img></a></td>
	 		<td style="width:60px;text-align:center"><a href="/UploadAndDownload/servlet/delete?filePath=<%=file.getAbsolutePath() %>"><img src="img/drop.gif"></img></a></td>
	 	</tr>
	 <%
	 	}
	  %>
	 </table>
</body>
</html>