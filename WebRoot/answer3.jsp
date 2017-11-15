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
    <link rel="stylesheet" href="css/answer.css">
    <style>
      
    
    	body{padding-top: 50px;
    	     }   


    	hr.divider{
    		margin: 40px;
    	}
    	.nav img{
    		 width: 200px;
    		 height: 200px;
    		 position: fixed;
    		 
    		
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
    <div class="question">
      <h1 class="title">这是一个很长很长的标题，他是真的很长，真的很长啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</h1>
      <div class="authorData">
        <div class="avator">
          <img src="img/pic4.png"/>
        </div>
        <div class="authorName">
          <span class="name">Ivan</span>
          <span class="time">1天前</span>
        </div>
      </div>
      <p class="des">我要问的就是这些，再加点字来凑字数吧，凑字数是个技术活，我有独特的凑字数技巧。但即使是这样看起来也凑不够了啊。。我要问的就是这些，再加点字来凑字数吧，凑字数是个技术活，我有独特的凑字数技巧。但即使是这样看起来也凑不够了啊。。我要问的就是这些，再加点字来凑字数吧，凑字数是个技术活，我有独特的凑字数技巧。但即使是这样看起来也凑不够了啊。。我要问的就是这些，再加点字来凑字数吧，凑字数是个技术活，我有独特的凑字数技巧。但即使是这样看起来也凑不够了啊。。我要问的就是这些，再加点字来凑字数吧，凑字数是个技术活，我有独特的凑字数技巧。但即使是这样看起来也凑不够了啊。。</p>
    </div>
    <div class="subComment">
      <div class="blockTitle">
        <span class="blockTitle-title"><span>5</span> 条回答</span>
        <span class="blockTitle-line"></span>
      </div>
      <div class="wrpper">
        <div class="avator">
          <img src="img/pic4.png"/>
        </div>
        <div class="inputWrapper">
          <form action="" method="post">
            <div class="commentContent" contenteditable="true"></div>
            <input type="submit" value="评论" class="submit"/>
            <input type="reset" value="清空" class="clear"/>
          </form>
        </div>
      </div>
    </div>
    <div class="comment">
      <div class="row">
        <div class="avator">
          <img src="img/pic4.png"/>
        </div>
        <div class="wrapper">
          <h3 class="name">Ivan</h3>
          <p class="detail">这是怎么做到的,再加点字来凑字数吧，凑字数是个技术活，我有独特的凑字数技巧。</p>
          <span class="time">1小时前</span>
        </div>
      </div>

      <div class="row">
        <div class="avator">
          <img src="img/pic4.png"/>
        </div>
        <div class="wrapper">
          <h3 class="name">Ivan</h3>
          <p class="detail">这是怎么做到的,再加点字来凑字数吧，凑字数是个技术活，我有独特的凑字数技巧。这是怎么做到的,再加点字来凑字数吧，凑字数是个技术活，我有独特的凑字数技巧。这是怎么做到的,再加点字来凑字数吧，凑字数是个技术活，我有独特的凑字数技巧。这是怎么做到的,再加点字来凑字数吧，凑字数是个技术活，我有独特的凑字数技巧。</p>
          <span class="time">1天前</span>
        </div>
      </div>

      <div class="row">
        <div class="avator">
          <img src="img/pic4.png"/>
        </div>
        <div class="wrapper">
          <h3 class="name">Ivan</h3>
          <p class="detail">这是怎么做到的,再加点字来凑字数吧，凑字数是个技术活，我有独特的凑字数技巧。</p>
          <span class="time">1月前</span>
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





