<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script type="text/javascript" src="https://www.echartsjs.com/gallery/vendors/echarts/map/js/china.js?_v_=1548453451319"></script> 
</head>
<body>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main1" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        $(function(){
        	
        var myChart = echarts.init(document.getElementById('main1'));
        $.post("${pageContext.request.contextPath }/User/b.do",function(result){
        	
        var option = {
        	    title : {
        	        text: 'iphone销量',
        	        subtext: '纯属虚构',
        	        left: 'center'
        	    },
        	    tooltip : {
        	        trigger: 'item'
        	    },
        	    legend: {
        	        orient: 'vertical',
        	        left: 'left',
        	        data:['数量']
        	    },
        	    visualMap: {
        	        min: 0,
        	        max: 2500,
        	        left: 'left',
        	        top: 'bottom',
        	        text:['高','低'],           // 文本，默认为数值文本
        	        calculable : true
        	    },
        	    toolbox: {
        	        show: true,
        	        orient : 'vertical',
        	        left: 'right',
        	        top: 'center',
        	        feature : {
        	            mark : {show: true},
        	            dataView : {show: true, readOnly: false},
        	            restore : {show: true},
        	            saveAsImage : {show: true}
        	        }
        	    },
        	    series : [
        	        {
        	            name: '数量',
        	            type: 'map',
        	            mapType: 'china',
        	            roam: false,
        	            label: {
        	                normal: {
        	                    show: false
        	                },
        	                emphasis: {
        	                    show: true
        	                }
        	            },
        	            data:result
        	        },   ]
    	};
        // 使用刚指定的配置项和数据显示图表。
           myChart.setOption(option);
        })
        })
       </script>
   </body>
   </html>

        	      