<span style="font-family:Comic Sans MS;font-size:18px;"><%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>  
<%  
    String path = request.getContextPath();  
%>  
  
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		 <meta charset="utf-8">
          <meta http-equiv="X-UA-Compatible" content="IE=edge">
         <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>注册</title>
		<script src="js/jquery.min.js"></script>
		<style>
			*{
				margin: 0;
				padding: 0;
				border: 0;
			}
			html,body{
				/*background: #110b2e;*/
				background: url(img/1.jpg) no-repeat;
				background-size: 100% 100%;
				height: 100%;
			}
			canvas {
				width: 100%;
				height: 100%;
				position: fixed;
				top: 0;
				left: 0;
			}
			.reg{
				width: 500px;
				height: auto;
				background: rgba(255,255,255,0.75);
				position: absolute;
				top: 50%;
				left: 50%;
				-webkit-transform: translate(-50%,-50%);
				-moz-transform: translate(-50%,-50%);
				-ms-transform: translate(-50%,-50%);
				-o-transform: translate(-50%,-50%);
				transform: translate(-50%,-50%);
				min-height: 200px;
				border-radius: 12px;
			}
			.reg h3,h4{
				font-size: 1。4em;
				color: rgb(216,76,41);
				font-family:"新宋体";
				text-align: center;
				margin: 24px 0 32px;
			}
			.reg form{
				width: 85%;
				margin: 0 auto;
			}
			.reg .row{
				width: 100%;
				margin-bottom: 24px;
				display: block;
				overflow: hidden;
			}
			.reg label{
				width: 20%;
				float: left;
				line-height: 32px;
			}
			.reg .input{
				width: 80%;
				float: left;
				height: 32px;
				text-indent: 1em;
				outline: none;
			}
			.reg .submit{
				width: 72%;
				height: 42px;
				background: #02171a;
				text-align: center;
				line-height: 42px;
				-webkit-border-radius: 42px;
				-moz-border-radius: 42px;
				-ms-border-radius: 42px;
				-o-border-radius: 42px;
				border-radius: 42px;
				display: block;
				position: relative;
				-webkit-transition-timing-function: all cubic-bezier(0.2, 1, 0.3, 1);
				-moz-transition-timing-function: all cubic-bezier(0.2, 1, 0.3, 1);
				-ms-transition-timing-function: all cubic-bezier(0.2, 1, 0.3, 1);
				-o-transition-timing-function: all cubic-bezier(0.2, 1, 0.3, 1);
				transition-timing-function: all cubic-bezier(0.2, 1, 0.3, 1);
				z-index: 1;
				margin: 0 auto 24px;
				color: #ffffff;
				text-decoration: none;
			}
			.reg .submit::before {
				background: #699f65;
				content: '';
				position: absolute;
				top: 0;
				left: 0;
				width: 100%;
				height: 100%;
				z-index: -1;
				opacity: 0;
				-webkit-transform: scale3d(0.7, 1, 1);
				-moz-transform: scale3d(0.7, 1, 1);
				-ms-transform: scale3d(0.7, 1, 1);
				-o-transform: scale3d(0.7, 1, 1);
				transform: scale3d(0.7, 1, 1);
				-webkit-transition: -webkit-transform 0.4s, opacity 0.4s;
				-moz-transition: transform 0.4s, opacity 0.4s;
				-ms-transition: transform 0.4s, opacity 0.4s;
				-o-transition: transform 0.4s, opacity 0.4s;
				transition: transform 0.4s, opacity 0.4s;
				-webkit-transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
				-moz-transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
				-ms-transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
				-o-transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
				transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
				-webkit-box-sizing: border-box;
				box-sizing: border-box;
				border-radius: 31px;
			}		
			.reg .submit:hover::before {
				opacity: 1;
				-webkit-transform: translate3d(0, 0, 0);
				transform: translate3d(0, 0, 0);
				background: #699f65;
			}
			.reg .submit:hover{
				color: #37474F;
			}
		</style>
	<script type="text/javascript">  
    function dosubmit() {  
        var th = document.form;  
        if (th.username.value == "") {  
            alert("用户名不能为空哦！");  
            th.username.focus();  
            return;  
        }  
  
        if (th.password.value == "") {  
            alert("密码不能为空哦！");  
            th.realname.focus();  
            return;  
        }  
  
        if (th.repassword.value == "") {  
            alert("记得重新输入密码哦！");  
            th.repassword.focus();  
            return;  
        }  
        if (th.repassword.value != th.password.value) {  
            alert("两次密码不一致哦！");  
            th.password.focus();  
            return;  
        }  
        th.action="<%=path%>/RegServlet";  
        th.submit();  
  
    }  
    function myReload()
	{ 
		document.getElementById("CreateCheckCode").src=document.getElementById("CreateCheckCode").src+
		"?nocache=" + new Date().getTime(); }  
</script>  
 
	</head>
	<body>
		<canvas></canvas>
		
		<div class="reg">
			<h4>啊喔，用户名重名，重新注册吧！</h4>
			<form action="" name="form" method="post">  
				<div class="row">
					<label for="username">用户名:</label><input type="text" name="username" id="username" placeholder="请设置用户名" class="input"/>
				</div>
				<div class="row">
					<label for="password">密 码:</label><input type="password" name="password" id="password" placeholder="请设置密码" class="input"/>
				</div>
				<div class="row">
					<label for="repassword">确认密码:</label><input type="password" name="repassword" id="repassword" placeholder="请确认密码" class="input"/>
				</div>
				<div class="row">
					<label for="username">验证码:</label><input type="text" name="checkcode" id="checkcode" placeholder="请输入验证码" class="input"/>
				   <img src="ImageServlet" id="CreateCheckCode" align="middle" onclick="javascript:myReload()"> 
         		   <input type="button" value="看不清，换一张" onclick="myReload()">
         					
         				
				</div>
				<a href="javascript:dosubmit();" class="submit">立即注册</a>
				
				
				
			</form>
		</div>
		
		<script>
			$(function() {
				var canvas = document.querySelector('canvas'),
					ctx = canvas.getContext('2d')
				canvas.width = window.innerWidth;
				canvas.height = window.innerHeight;
				ctx.lineWidth = .3;
				ctx.strokeStyle = (new Color(150)).style;

				var mousePosition = {
					x: 30 * canvas.width / 100,
					y: 30 * canvas.height / 100
				};

				var dots = {
					nb: 150,
					distance: 50,
					d_radius: 100,
					array: []
				};

				function colorValue(min) {
					return Math.floor(Math.random() * 255 + min);
				}

				function createColorStyle(r, g, b) {
					return 'rgba(' + r + ',' + g + ',' + b + ', 0.8)';
				}

				function mixComponents(comp1, weight1, comp2, weight2) {
					return(comp1 * weight1 + comp2 * weight2) / (weight1 + weight2);
				}

				function averageColorStyles(dot1, dot2) {
					var color1 = dot1.color,
						color2 = dot2.color;

					var r = mixComponents(color1.r, dot1.radius, color2.r, dot2.radius),
						g = mixComponents(color1.g, dot1.radius, color2.g, dot2.radius),
						b = mixComponents(color1.b, dot1.radius, color2.b, dot2.radius);
					return createColorStyle(Math.floor(r), Math.floor(g), Math.floor(b));
				}

				function Color(min) {
					min = min || 0;
					this.r = colorValue(min);
					this.g = colorValue(min);
					this.b = colorValue(min);
					this.style = createColorStyle(this.r, this.g, this.b);
				}

				function Dot() {
					this.x = Math.random() * canvas.width;
					this.y = Math.random() * canvas.height;

					this.vx = -.5 + Math.random();
					this.vy = -.5 + Math.random();

					this.radius = Math.random() * 2;

					this.color = new Color();
				}

				Dot.prototype = {
					draw: function() {
						ctx.beginPath();
						ctx.fillStyle = this.color.style;
						ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2, false);
						ctx.fill();
					}
				};

				function createDots() {
					for(i = 0; i < dots.nb; i++) {
						dots.array.push(new Dot());
					}
				}

				function moveDots() {
					for(i = 0; i < dots.nb; i++) {

						var dot = dots.array[i];

						if(dot.y < 0 || dot.y > canvas.height) {
							dot.vx = dot.vx;
							dot.vy = -dot.vy;
						} else if(dot.x < 0 || dot.x > canvas.width) {
							dot.vx = -dot.vx;
							dot.vy = dot.vy;
						}
						dot.x += dot.vx;
						dot.y += dot.vy;
					}
				}

				function connectDots() {
					for(i = 0; i < dots.nb; i++) {
						for(j = 0; j < dots.nb; j++) {
							i_dot = dots.array[i];
							j_dot = dots.array[j];

							if((i_dot.x - j_dot.x) < dots.distance && (i_dot.y - j_dot.y) < dots.distance && (i_dot.x - j_dot.x) > -dots.distance && (i_dot.y - j_dot.y) > -dots.distance) {
								if((i_dot.x - mousePosition.x) < dots.d_radius && (i_dot.y - mousePosition.y) < dots.d_radius && (i_dot.x - mousePosition.x) > -dots.d_radius && (i_dot.y - mousePosition.y) > -dots.d_radius) {
									ctx.beginPath();
									ctx.strokeStyle = averageColorStyles(i_dot, j_dot);
									ctx.moveTo(i_dot.x, i_dot.y);
									ctx.lineTo(j_dot.x, j_dot.y);
									ctx.stroke();
									ctx.closePath();
								}
							}
						}
					}
				}

				function drawDots() {
					for(i = 0; i < dots.nb; i++) {
						var dot = dots.array[i];
						dot.draw();
					}
				}

				function animateDots() {
					ctx.clearRect(0, 0, canvas.width, canvas.height);
					moveDots();
					connectDots();
					drawDots();

					requestAnimationFrame(animateDots);
				}

				$('canvas').on('mousemove', function(e) {
					mousePosition.x = e.pageX;
					mousePosition.y = e.pageY;
				});

				$('canvas').on('mouseleave', function(e) {
					mousePosition.x = canvas.width / 2;
					mousePosition.y = canvas.height / 2;
				});

				createDots();
				requestAnimationFrame(animateDots);
			});
		</script>

	</body>

</html>
