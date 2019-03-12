<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>registe</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<!--背景-->
<div class="wel" id="background-3"></div>
<!--左右两边云-->
<div class="wel" id="box">
    <div class="box-1 lefp"></div>
    <div class="box-1">
        <div class="righp"></div>
    </div>
</div>
<!--荧光点点-->
<div class="wel" id="git"></div>
<!--登录注册表-->
<div class="wel" id="from">
    
    <div class="box-2 le-2">
        <form action="${pageContext.request.contextPath }/User/insert.do" method="post">
            <div class="flrg-1">
                <h3>注册</h3>
                <div class="a">
                    <input type="text" class="in-1" name="dharmaname" placeholder="您的法名">
                </div>
                <div class="a">
                    <input type="password" class="in-1" name="password" placeholder="输入密码">
                </div>
                <div class="a">
                	<td>性&nbsp;别：</td>
  					<td>
  					        男<input type="radio" class="inputgri" name="sex" value="0" style="width: 10px"/>
						女<input type="radio" class="inputgri" name="sex" value="1" checked="checked" style="width: 10px" />
  					</td>
  				</div>
                <div class="a">
                    <button type="submit">注册</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>