<%@ page language="java" import="java.util.*" pageEncoding="utf-8" import="vo.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%AskVo detail=(AskVo)session.getAttribute("question"); %>
<%String username=(String)request.getAttribute("username"); %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showQuestDetail.jsp' starting page</title>
    
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
  	 
   	<div class="content1"><%=detail.getQtitle()%></div><div class="content2"><%=detail.getQcontent() %></div>
   	<div class="content3"><%=detail.getName() %></div>
   	<div>当前用户：<%=username %></div>
  </body>
</html>
