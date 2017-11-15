<%@ page language="java" import="java.util.*"  import="vo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%RegVo User=(RegVo)session.getAttribute("User"); %>



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
    		background-color: rgb(70,157,251);
    	}
    	
    	.jumbotron h1{
    		font-family: "微软雅黑";
    		margin-bottom: 40px;
    	}
    		
    	.query{
    		  
    		   margin-top: 100px;
    		   margin-left: 200px;
    		   margin-right:200px;
    		 
    		
    	}
    	.media h4{
    		   color: rgb(51,122,183);
    	}
    	.media img{
    	 width:234px;
    	 height:168px;
    	 }
    	
    </style>
   <script type="text/javascript" >
   	function  showImg(){
    document.getElementById("wxImg").style.display='block';}
    function hideImg(){
    document.getElementById("wxImg").style.display='none';}
   </script>
  </head>
  
  <body>
   <jsp:include page="/QuestionServlet"></jsp:include> 

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
          <li><a href="#" target="_blank"><%=User.getName() %>，您好！</a></li>
          
          
        
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

  
<div class="jumbotron">
	 
  <h1>如何从头学Java?</h1>
  
  <p><a class="btn btn-primary btn-lg" href="#" role="button">我来回答</a>
  	  &nbsp;&nbsp;&nbsp;
  	 <a class="btn btn-primary btn-lg" href="#" role="button">查看回答</a>
  </p>
</div>

<div class="query">
<p><a class="btn btn-primary btn-lg" href="ask.jsp" role="button">我想提问</a>
  	 
  </p>
 <%ArrayList list1=(ArrayList)session.getAttribute("question"); 
  		for(int i=0;i<list1.size();i++){
  			AskVo question=(AskVo)list1.get(i);
  	%>
  <hr class="divider">
   <p><div class="media">
   <div class="media-left media-middle">
   <a href="DetailServlet?type=detail&&qtitle=<%=question.getQtitle()%>&&username=<%=User.getName()%>">
      <img class="media-object" src="img/wen.jpg" alt="...">
    </a>
  </div>
  <div class="media-body">
    <h4 class="media-heading"><%=question.getQtitle()%></h4>
    <%=question.getQcontent() %>
  </div>
</div></p>
<%} %>


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





