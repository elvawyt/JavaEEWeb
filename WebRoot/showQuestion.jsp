<%@ page language="java" import="java.util.*" pageEncoding="utf-8" import="vo.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showQuestion.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	div{
		margin:0 auto;
	}
		.content1{
			width:400px;
			height:30px;
			background-color:pink;
		}
		.content2{
			width:400px;
			height:30px;
			background-color:green;
		}
		.content3{
			width:400px;
			height:30px;
			background-color:#eee;
		}
	</style>

  </head>
  
  <body>
  <jsp:include page="/QuestionServlet"></jsp:include> 
  	<%ArrayList list1=(ArrayList)session.getAttribute("question"); 
  		for(int i=0;i<list1.size();i++){
  			AskVo question=(AskVo)list1.get(i);
  	%>
  	 <div>#<%=i+1 %></div>
  	 
   	<div class="content1"><%=question.getQtitle()%></div><div class="content2"><%=question.getQcontent() %></div>
   	<div class="content3"><%=question.getName() %></div>
   <%} %>
  </body>
</html>
