<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="../js/themes/default/easyui.css">   
<script type="text/javascript" src="../js/jquery.min.js"></script>   
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/cmfz_lwl/js/echarts.js"></script>
<script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>

</head>
<body>  
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
     var goEasy = new GoEasy({
		appkey: 'BC-8a3923492e974293a832321d4afe1ff8'
		});
		goEasy.subscribe({
		channel:'channel',
		onMessage: function(message){
		var message1=JSON.parse(message.content);
			alert(message);
			
			console.log(message1.男);
		  var option = {
            title: {
                text: '用户注册信息'
            },
            tooltip: {},
            legend: {
                data:['男','女']
            },
            xAxis: {
                data:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
            },
            yAxis: {},
            series: [{
                name: '男',
                type: 'bar',
                data: message1.男
            },{
                name: '女',
                type: 'bar',
                data: message1.女
            }],
       
        };
            myChart.setOption(option);	
		}
		});		
       //var myChart = echarts.init(document.getElementById('main'));
	$.post("${pageContext.request.contextPath }/User/a.do",function(data){
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '用户注册信息'
            },
            tooltip: {},
            legend: {
                data:['男','女']
            },
            xAxis: {
                data:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
            },
            yAxis: {},
            series: [{
                name: '男',
                type: 'bar',
                data: data.男
            },{
                name: '女',
                type: 'bar',
                data: data.女
            }],
       
        };
        
            myChart.setOption(option);
            },"json");

/** <script type="text/javascript">
var myChart = echarts.init(document.getElementById('main'));
var goEasy = new GoEasy({
	appkey: 'BC-8a3923492e974293a832321d4afe1ff8'
	});
		//var myChart = echarts.init(document.getElementById('main'));
goEasy.subscribe({
	channel:'channel',
	onMessage: function(message1){
		console.log(message1);
		var message = JSON.parse(message1.content);
	alert('收到：'+message);
	
		//$.post("${pageContext.request.contextPath }/User/a.do",function(result){
			//console.log(result);
			 var option = {
		            title: {
		                text: '注册数量展示'
		            },
		            tooltip: {},
		            legend: {
		                data:['女']
		            },
		            xAxis: {
		                data: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
		            },
		            yAxis: {},
		            series: [{
		            	name:"女",
		            	type:"bar",
		            	data:message.女
		            }]
		        };
			if (myChart != null && myChart!= "" && myChart!= undefined) {
				myChart.dispose();
				}
			 myChart.setOption(option);
		//},"json");	
	
	 
	}
	});
		$.post("${pageContext.request.contextPath }/User/a.do",function(result){
			console.log(result);
			var option = {
		            title: {
		                text: '注册数量展示'
		            },
		            tooltip: {},
		            legend: {
		                data:['男','女']
		            },
		            xAxis: {
		                data: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
		            },
		            yAxis: {},
		            series: [{
		                name: '男',
		                type: 'bar',
		                data: result.男
		            },{
		            	name:"女",
		            	type:"bar",
		            	data:result.女
		            }]
		        };
			
			 myChart.setOption(option);
		},"json");	
		 */
</script>

</body> 
</html>