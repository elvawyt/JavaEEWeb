<%@ page language="java" import="java.util.*" import="vo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
            color: #CE8483;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
        .btn-group form{
            margin: 0;
            margin-left: 12px;
        }
        .btn-group form select{
            margin: 0;
            margin-right: 12px;
        }
    </style>

   
   
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <jsp:include page="/ResourceManage"></jsp:include> 
  <body class=""> 
  <!--<![endif]-->
    
    <div class="navbar" >
        <div class="navbar-inner" >
                <ul class="nav pull-right">
                    
                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">设置</a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> 管理员系统
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            
                            <li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="login.jsp">退出登录</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="usermanage.jsp"></span><span class="first">I-java <span class="second">Admin</span></a>
        </div>
    </div>
    


    
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>菜单管理</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="index.html" target="_blank" >主页</a></li>
            <li><a href="usermanage.jsp">用户管理</a></li>
            <li  class="active"><a href="resourcemanage.jsp">资源管理</a></li>
            <li ><a href="querymanage.jsp">问答管理</a></li>
            
            
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>账户<span class="label label-info">+3</span></a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="sign-in.html">新增管理员</a></li>
            <li ><a href="login.jsp">退出登录</a></li>
            <li ><a href="reset-password.html">重置密码</a></li>
        </ul>

        <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-exclamation-sign"></i>待开发<i class="icon-chevron-up"></i></a>
        <ul id="error-menu" class="nav nav-list collapse">
            <li ><a href="403.html">403 page</a></li>
            <li ><a href="404.html">404 page</a></li>
            <li ><a href="500.html">500 page</a></li>
            <li ><a href="503.html">503 page</a></li>
        </ul>

        <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-legal"></i>法律许可</a>
        <ul id="legal-menu" class="nav nav-list collapse">
            <li ><a href="privacy-policy.html">法律许可</a></li>
          
        </ul>

       
    </div>
    

    
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">Users</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.html">Home</a> <span class="divider">/</span></li>
            <li class="active">Users</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
    <a href="ResourceServlet?type=filter"><button class="btn btn-primary"><i class="icon-plus"></i>未审核</button></a>
   
  <div class="btn-group">
   
     <form action="MSearchServlet" method="post" >
   
     <select name="key">
     <option value="jsp">JSP</option>
      <option value="java">java</option>
       <option value="html">html</option>
        <option value="database">database</option>
         <option value="other">other</option>
     
     </select> 
     
     <button type="submit" class="btn btn-primary" float:left>Submit</button>
    
      </form>
      
  </div>
</div>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>资源名称</th>
          <th>是否通过</th>
          <th>权限</th>
          <th>上传者</th>
          
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
      <%ArrayList list1=(ArrayList)session.getAttribute("resource");
        for(int i=list1.size()-1;i>=0;i--){
        	ResourceVo reso=(ResourceVo)list1.get(i);
        %>
        <tr>
          <td>#<%=list1.size()-i%></td>
          <td><%=reso.getSourcename()%></td>
          <td><%=reso.getDlnumber() %></td>
          <td><%=reso.getPermission()%></td>
          <td><%=reso.getName()%></td>
          <td>
          	  <a href="ResourceServlet?type=changepermission&&sourcename=<%=reso.getSourcename()%>"><i class="icon-arrow-up"></i></a>
              <a href="ResourceServlet?type=agreeupload&&sourcename=<%=reso.getSourcename()%>"><i class="icon-ok"></i></a>
             
          </td>
        </tr>
<%} %>
        
      </tbody>
    </table>
</div>
<div class="pagination">
    <ul>
        <li><a href="#">Prev</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">Next</a></li>
    </ul>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">确认删除</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>你确定删除该用户吗？</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
        <button class="btn btn-danger" data-dismiss="modal">删除</button>
    </div>
</div>


                    
                    <footer>
                        <hr>

                        
                        

                        <p>&copy; 2017 王羽桐  太原理工大学</a></p>
                    </footer>
                    
            </div>
        </div>
    </div>
    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


