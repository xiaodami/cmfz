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

</head>
<body>  
<script type="text/javascript">
	$(function(){
		
		$("#t2").datagrid({
			title:'用户管理',
			fit:true,
			fitColumns:true,
			loadMsg:'等着吧',
			url:'${pageContext.request.contextPath }/meun/selectAllObject.do?t=<%=request.getParameter("h") %>',
			columns:[[
				
		          {field:'id',width:150,title:'用户id',
		          }, 
		          {field:'dhramaname',width:150,title:'法名', align:'center', // 列内容对齐方式
		        	  halign:'center',},					    
		          {field:'phono',width:200,title:'用户头像',align:'left',
		        	  halign:'center'},
		           {field:'realname',width:300,title:'用户名',
		        	  halign:'center'},
		            {field:'sex',width:100,title:'性别',align:'center',
		        	  halign:'center'},
		             {field:'privonce',width:200,title:'时间',align:'center',
		        	  halign:'center'},				      
		             {field:'privonce',width:200,title:'省份',align:'center',
		        	  halign:'center'},				      
		             {field:'city',width:200,title:'城市',align:'center',
		        	  halign:'center'},				      
		             {field:'sign',width:200,title:'签名',align:'center',
		        	  halign:'center'},				      
		             {field:'phoneNum',width:200,title:'手机',align:'center',
		        	  halign:'center'},				      
		             {field:'createtime',width:200,title:'注册时间',align:'center',
		        	  halign:'center'},				      
		             {field:'status',width:200,title:'状态',align:'center',
		        	  halign:'center'},				      
		          ]],
		          /*  view:detailview, 
					detailFormatter: function(rowIndex, row){ 
					return '<table><tr>' + 
					'<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath }/imgPath/' + row.img_path + '" style="height:50px;"></td>' + 
					'<td style="border:0">' + 
					'<p>Title: ' + row.title + '</p>' + 
					'<p>Description: ' + row.description + '</p>' + 
					'<p>Status: ' + row.status + '</p>' + 
					'<p>Create_time: ' + row.createTime + '</p>' + 
					'</td>' + 
					'</tr></table>'; 
					} , */
					toolbar:[{
    					text:'生成文档',
    					iconCls:'icon-undo',
    					handler:function(){
    						/* var select = $('#t1').treegrid('getSelected');   						
    						if(select==null){
    							$.messager.alert('提示','请选中您要下载的章节','warning');
    						}else{
    							if(select._parentId==null){
    								 $.messager.alert('提示','请选中您要下载的章节信息','warning');   								
    							} */
    							//url+"&groupName=" + encodeURI(encodeURI(select.url)) ;
    							location.href="${pageContext.request.contextPath }/User/download.do?";
    					/* 	}
    					}, */}
    					
    				}],
			         
			         pagination:true,
					 pageNumber:1,
					 pageSize:5,
					 pageList:[2,3,4,5,10,20],
					 rownumbers:true,
					 singleSelect:false,
					 checkOnSelect:true, 
		});
	});
</script>
	<table id="t2"></table>
</body> 
</html>