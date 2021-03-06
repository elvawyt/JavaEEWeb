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
      
    
    	body{padding-top: 50px;}   
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
    		margin-bottom: 80px;
    		
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
    .thumbnail img{
    	    width: 270px;
    		 height: 270px;
    		 
    	}
    	
    	#summary-container .col-md-4{
    		text-align: center;
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
        <li class="active"><a href="resource.jsp"target="_self">资源 <span class="sr-only">(current)</span></a></li>
        <li><a href="query.jsp"target="_self">问答</a></li>
        <li><a href="about.html" target="_blank">关于</a></li>
       
        
          </ul>
        </li>
      </ul>
      <form action="SearchServlet" method="post" class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" name="key">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">

          
         <li><a href="#" target="_blank"><%=User.getName() %>，您好！</a></li>
         <li><a href="update.jsp" target="_blank">上传得积分，点击上传</a></li>
          
          
        
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<div class="container" id="summary-container">
 <div class="row">
  <jsp:include page="/ShowResourceServlet"></jsp:include>
  <%ArrayList list1=(ArrayList)session.getAttribute("ResourceList");
        for(int i=0;i<list1.size();i++){
        	ResourceVo reso=(ResourceVo)list1.get(i);
        	if(reso.getDlnumber()==1){
        %>
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
     <%System.out.println(reso.getSourcetype()); %>
    	          <%if (reso.getSourcetype().equals("java")){ %>
                  	<img src="img/xing1.png" alt="...">
                    	<%} else if (reso.getSourcetype().equals("html")){%>
    	                 
    	                 <img src="img/xing3.png" alt="...">
                         	<%} else if(reso.getSourcetype().equals("jsp")){%>    
                         	 <img src="img/xing4.png" alt="...">
                         	 <%} else{ %>
                         	  <img src="img/xing5.jpg" alt="...">
                         	  <%} %>
      <div class="caption">
        <h3><%=reso.getSourcename()%></h3>        
        <p>...</p>
        <p><a href="try.jsp?sourcename=<%=reso.getSourcename() %>&&sourcecontent=<%=reso.getSourcecontent() %>&&permission=<%=reso.getPermission() %>&&path=<%=reso.getPath() %>" class="btn btn-primary" role="button">Read more</a></p>
      </div>
    </div>
  </div>
  <% }} %>
    </div>
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





