<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%
	request.setAttribute("path", request.getContextPath());
 %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="${path }/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${path }/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${path }/css/login.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="${path }/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${path }/themes/icon.css">
	<script type="text/javascript" src="${path }/script/jquery.js"></script>
	<script type="text/javascript" src="${path }/script/common.js"></script>
	<script type="text/javascript" src="${path }/js/jquery.easyui.min.js"></script>
	<script type="text/javascript">	
	function go(){	
					location.reload();
					}
	function textcode(){
				var captcha = document.getElementById('captcha').value;
				console.log(captcha)
				var xhr;
				if(window.ActiveXObject){
				xhr = new ActiveXObject('Microsoft.xmlhttp');
			}else{
				xhr = new XMLHttpRequest();
				}
				//设置请求类型和请求目标
				xhr.open('POST', '${pageContext.request.contextPath}/Admin/judge.do');
				//设置一个请求头
				xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
				xhr.send("captcha="+captcha);
				var codeinfo = document.getElementById('aaa');
				xhr.onreadystatechange = function(){
					if(xhr.readyState==4 && xhr.status==200){
					//获取响应结果
					var txt = xhr.responseText;
					if(txt=='ok'){
						codeinfo.innerHTML="<font color='green'>验证码正确</font>";
						}else{
						codeinfo.innerHTML="<font color='red'>验证码错误</font>";
						}
					}
				}
			}
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
				$("#captchaImage").prop("src","${pageContext.request.contextPath}/Admin/yan.do?time="+new Date().getTime());
				/* var img=document.getElementById("captchaImage");
				img.src="${pageContext.request.contextPath}/Admin/yan.do?time="+new Date().getTime(); */
			});
			
			//  form 表单提交
			$("#loginForm").bind("submit",function(){
				var f1 = $("#name").validatebox('isValid');
				console.log(f1)
				var f2 = $("#password").validatebox('isValid');
				console.log(f2)
				if(f1 && f2 == true){
					var captcha = document.getElementById('captcha').value;
					console.log(captcha);
					$.post("${pageContext.request.contextPath}/Admin/judge.do","captcha="+captcha,function(txt){
						console.log(txt.length)
						if(txt.length==4){
							var name = $('#name').val();
							var pwd = $('#password').val();					
							$.post('${path}/Admin/login.do','name='+name+'&password='+pwd,function(data){
								console.log(data)
								if(data!=null){
									location.href = "${path}/main/main.jsp";
									return true;
								}else{
									$.messager.alert('提示',"请输入正确的账号密码");
									//3秒后重载页面
									window.setTimeout(go,3000);
								}
							});	
					
						//codeinfo.innerHTML="<font color='green'>验证码正确</font>";
						
						}else{
						//codeinfo.innerHTML="<font color='red'>验证码错误</font>";
						alert("请输入正确的验证码")
						}
					})
								
				}
				return false;
			});
			
			$("#name").validatebox({    
			    required: true,    
			    validType: 'length[3,8]',
			    missingMessage:'请输入用户名',
				invalidMessage:'请输入正确的格式'   
			}); 
			$("#password").validatebox({    
			    required: true,    
			    validType: 'length[3,8]',
			    missingMessage:'请输入密码',
				invalidMessage:'请输入正确的格式'   
			}); 
			
						
		});
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm" action="" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text" id="name" name="name" class="text" value="" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" id="password" name="password" class="text" value="" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text"  id="captcha" name="captcha" class="text captcha" maxlength="4" autocomplete="off" onblur="textcode();" /><span id="aaa" ></span>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/Admin/yan.do" title="点击更换验证码"/>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='${path}/login.jsp'"><input type="submit" class="loginButton" value="登录">
							<input type="button" class="homeButton" value="" onclick="location.href='${path}/login.jsp'"><input type="button" class="loginButton" value="注册" onclick="location='${pageContext.request.contextPath}/register.jsp'">
						</td>
						<td>
							
							
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>