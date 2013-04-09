<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>servlet上传下载Demo</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function go(){
			var files = document.getElementById('file').files;
			var isOk = true;
			var log = document.getElementById('info');
			for(var i = 0; i < files.length; i++){
				if(files[i].size > 10485760){
					log.innerHTML = log.innerHTML + files[i].name + "超过10M<br>";
					isOk = false;
				}
			}
			if(isOk){
				log.innerHTML = "";
				document.getElementById('file_form').submit();
			}
		}
	</script>
  </head>
  
  <body>
  	<form id="file_form" action="/UploadAndDownload/servlet/upload" method="post" enctype="multipart/form-data" target="list">
  		<input type="file" name="file" id="file" multiple>
  		<input type="button" value="提交" onclick="go();">
  	</form>
  	<label id="info" style="color:red"></label>
  	<br/>
  	<iframe id="list" style="width:100%;height:600px;border:0px;" src="filelist.jsp"></iframe>
  </body>
</html>
