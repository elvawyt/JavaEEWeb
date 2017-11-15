<%@ page language="java" import="java.util.*" import="vo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%AskVo detail=(AskVo)session.getAttribute("question"); %>
<%String name=(String)request.getAttribute("name"); %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>ijava-玩转java</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
      
    
    	body{padding-top: 50px;
    	     }   
	    .carousel {
	    	height: 400px;
	    	background-color: #000000;
	    }
    	.carousel .item{
    		height: 400px;
    		background-color: #000000;
    	}
    	.carousel img{
    		
    		width: 100%;
    		
    	}
    	.carousel-caption p{
    		margin-bottom: 20px;
    		font-size: 20px;
    		line-height: 1.8;
    		
    	}
    	
    	 .row{
    	 	
    	 	margin: 50px;
    	 }
    	.row img{
    		 width:100%;
    		 height: 100%;
    		
    	
    	}
    	hr.divider{
    		margin: 40px;
    	}
    	.nav img{
    		 width: 200px;
    		 height: 200px;
    		 position: fixed;
    		 
    		
    	}
    	.jumbotron {
    		text-align: center;
    		background-color: #F8B9B7;
    	}
    	
    	.jumbotron h1{
    		font-family: "微软雅黑";
    		margin-bottom: 40px;
    	}
    		
    	.query{
    		  
    		   margin-top: 100px;
    		   margin-left: 200px;
    		   margin-right: 200px;
    		   
    		 
    		
    	}
    	.media h4{
    		   color: rgb(51,122,183);
    	}
    	
    	
    </style>
    
   <script type="text/javascript" >
   	function  showImg(){
    document.getElementById("wxImg").style.display='block';}
    function hideImg(){
    document.getElementById("wxImg").style.display='none';}
   </script>
   <script type="text/javascript">  
		function tosubmit() {  
    	 var th = document.form; 
    	 th.action="<%=path%>/AnswerServlet";  
    	 
         th.submit();  
    }
		</script>
  </head>
  
  <body>

  <nav class="navbar navbar-default navbar-fixed-top " role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="user.jsp"target="_self">iJava 资源分享平台</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li ><a href="resource.jsp"target="_self">资源 </a></li>
        <li class="active"><a href="query.jsp"target="_self">问答</a></li>
        <li><a href="about.html" target="_blank">关于</a></li>
       
        
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">

          <li><a href="javascript:void(0)" onMouseOut="hideImg()" onmouseover="showImg()">联系我们</a><div id="wxImg" style="display:none;height:50px;back-ground:#f00;position:absolute;"><img src="img/wechat.jpg"></div></li>

          
          
          
        
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

 

<div class="query">
	 

          <div class="jumbotron">
          
   
  <h1><%=detail.getQtitle()%></h1>
  <p><%=detail.getQcontent() %></p>
  
</div> 
             
       
        <hr class="divider">
                     

  	
  	 
 <div class="container-fluid">
 <div class="row-fluid">
                    
<input style="display:none" value="<%=detail.getQtitle()%>" id="qtitle" name="qtitle">
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>回答内容</th>
          <th>回答者</th>
          
          
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
      <jsp:include page="/ShowAnswerServlet"></jsp:include> 
       <%ArrayList list1=(ArrayList)session.getAttribute("answer"); 
  		for(int i=0;i<list1.size();i++){
  			AnswerVo an=(AnswerVo)list1.get(i);
  	%>
        <tr>
          <td><%=i+1 %></td>
          <td><%=an.getAcontent()%></td>
          <td><%=an.getName() %></td>
          
          <td>
          	  <a href="changepermission.jsp"><i class="icon-remove"></i></a>
              <a href="user.html"><i class="icon-ok"></i></a>
             
          </td>
        </tr>
        <%} %>
      </tbody>
    </table>
</div>
   
  
<hr class="divider">
	
	<footer>
		<p class="pull-right"><a href="#top">回到顶部</a></p>
		<p> 2017 Elva Wang</p>
	</footer>

 <script src="js/jquery-3.1.1.min.js"></script>
   <script src="js/jquery-3.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>





