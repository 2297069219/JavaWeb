<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>

	<%-- 静态包含 base标签 css样式 jQuery文件--%>
	<%@ include file="/pages/common/head.jsp"%>

	<script type="text/javascript">



		$(function(){


			$("#username").blur(function () {
				var username=this.name;

				$.getJSON("http://localhost:8080/book/userServlet","action=ajaxExistsUsername&username="+username,function(data){
					if(data.existsUsername){
						$("span.errorMsg").text("用户名已存在！");
					}else{
						$("span.errorMsg").text("用户名可用！");
					}
				});

			});


			$("#code_img").click(function(){
				//在时间响应的function中 this表示当前正在响应的事件dom对象
				//src 验证码的img标签 路径 可读可写 赋值可重新发起请求 ie 火狐第一次不行
				//浏览器 客户端 为了让请求速度更快 每次请求的保存在缓存中 磁盘 内存 浏览器端
				//服务器Tomcat 生成验证码图片 拿最后的请求当文件路径 kaptcha.jpg=返回的内容
				//直接从浏览器缓存中返回 跳过缓存后去图片 缓存名称最后的资源名和参数组成
				//?时间戳
				this.src="${basePath}/kaptcha.jpg?="+new Date();
			});

			$("#sub_btn").click(function () {
				//用户名 正则表达式 提示
				var usernameText = $("#username").val();

				var usernamePatt = /^\w{5,12}$/;
				if (!usernamePatt.test(usernameText)) {
					$("span.errorMsg").text("用户名不合法");
					return false;
				}


				var passwordText = $("#password").val();
				var passwordPatt = /^\w{5,12}$/;

				if (!passwordPatt.test(passwordText)) {
					$("span.errorMsg").text("密码不合法");
					return false;
				};

				var repwdTest =$("#repwd").val();
				if(repwdTest!=passwordText){
					$("span.errorMsg").text("确认密码buzque");
					return false;
				};


				//邮箱验证
				//获取内容
				var emailText=$("#email").val();
				var emailPatt=/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				if(!emailPatt.test(emailText)){
					$("span.errorMsg").text("email不合法");
					return false;
				};

				var codeTest=$("#code").val();
				 codeTest= $.trim(codeTest);
				if(codeTest==null||codeTest==""){
					$("span.errorMsg").text("非法");
					return false;
				}


				$("span.errorMsg").text("");


			});
		});
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									<%--<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   value="${requestScope.username}"
										   autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   value="${requestScope.email}"
										   autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 80px;"  id="code" />
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width:110px; height:30px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>

		<%--静态包含页脚内容--%>
		<%@include file="/pages/common/footer.jsp"%>


</body>
</html>