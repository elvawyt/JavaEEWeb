<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
      <a class="navbar-brand" href="index.html">iJava 资源分享平台</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li ><a href="resource.html" target="_self">资源</a></li>
        <li><a href="query.html" target="_self">问答</a></li>
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
          
          <li><a href="login.jsp" target="_blank">请登录</a></li>
          
          
        
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

   <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
  
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
  	
    <div class="item active">
      <img src="img/blue1.jpg" alt="0 slide">
      <div class="carousel-caption">
       <h1>welcome</h1>
       	<p>60秒带你入门java</p>
       	<p><a class="btn btn-lg btn-primary" href="#" target="_blank" role="button">详细</a></p>
       
      </div>
    </div>
    
    
    <div class="item">
      <img src="img/blue2.jpg" alt="1 slide">
      <div class="carousel-caption">
       	<h1>好无聊</h1>
       	<p>人家捶你小胸口</p>
       	<p><a class="btn btn-lg btn-primary" href="#" target="_blank" role="button">详细</a></p>
     </div>

    </div>
    
     <div class="item">
      <img src="img/pink1.jpg" alt="2 slide">
      <div class="carousel-caption">
       <h1>山洞</h1>
       	<p>修炼，过一生</p>
       	<p><a class="btn btn-lg btn-primary" href="#" target="_blank" role="button">详细</a></p>
       
      
      </div>
    </div>
    
     <div class="item">
      <img src="img/blue3.jpg" alt="3 slide">
      <div class="carousel-caption">
       <h1>加油</h1>
       	<p>offer榜</p>
       	<p><a class="btn btn-lg btn-primary" href="#" target="_blank" role="button">详细</a></p>
       
       
      </div>
    </div>
    
    
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

  <div class="container" id="summary-container">
 <div class="row">
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="img/pic6.jpg" alt="...">
      <div class="caption">
        <h3>Thumbnail label</h3>
        <p>...</p>
        <p><a href="#" class="btn btn-primary" role="button">Read more</a></p>
      </div>
    </div>
  </div>
 
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="img/pic6.jpg" alt="...">
      <div class="caption">
        <h3>Thumbnail label</h3>
        <p>...</p>
        <p><a href="#" class="btn btn-primary" role="button">Read more</a></p>
      </div>
    </div>
  </div>
  
   <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="img/pic6.jpg" alt="...">
      <div class="caption">
        <h3>Thumbnail label</h3>
        <p>...</p>
        <p><a href="#" class="btn btn-primary" role="button">Read more</a></p>
      </div>
    </div>
  </div>
  
</div>
</div>

  <hr class="divider">
 
 <div class="container" id="summary-container">
 <div class="row">
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="img/pic6.jpg" alt="...">
      <div class="caption">
        <h3>Thumbnail label</h3>
        <p>...</p>
        <p><a href="#" class="btn btn-primary" role="button">Read more</a></p>
      </div>
    </div>
  </div>
  
   <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="img/pic6.jpg" alt="...">
      <div class="caption">
        <h3>Thumbnail label</h3>
        <p>...</p>
        <p><a href="#" class="btn btn-primary" role="button">Read more</a></p>
      </div>
    </div>
  </div>
  
   <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="img/pic6.jpg" alt="...">
      <div class="caption">
        <h3>Thumbnail label</h3>
        <p>...</p>
        <p><a href="#" class="btn btn-primary" role="button">Read more</a></p>
      </div>
    </div>
  </div>
  
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

