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
		
		$("#t").datagrid({
			title:'轮播图管理',
			fit:true,
			fitColumns:true,
			loadMsg:'等着吧',
			url:'${pageContext.request.contextPath }/meun/selectAllObject.do?t=<%=request.getParameter("h") %>',
			columns:[[
				/* {field:'id',title:'ID',width:100},    
				{field:'title',title:'名称',width:100},    
				{field:'img_path',title:'图片路径',width:100}, 
				{field:'description',title:'描述',width:100}, 
				{field:'status',title:'状态',width:100}, 
				{field:'createTime',title:'时间',width:100}, 
				 */
				
					{field:'ck',width:100,checkbox:true},
		          {field:'id',width:150,title:'图片编号',
		        	  align:'center', // 列内容对齐方式
		        	  halign:'center', // 指定列标题对齐方式
		        	  sortable:true,//  必须将datagrid属性 remoteSort:false
		        	  resizable:false, // 是否允许拖拽改变列的大小
		          }, 
		          {field:'title',width:150,title:'图片名称', align:'center', // 列内容对齐方式
		        	  halign:'center',},					    
		          {field:'img_path',width:200,title:'图片路径',align:'left',
		        	  halign:'center'},
		           {field:'description',width:300,title:'图片描述',
		        	  halign:'center'},
		            {field:'status',width:100,title:'图片状态',align:'center',
		        	  halign:'center'},
		             {field:'createTime',width:200,title:'时间',align:'center',
		        	  halign:'center'},				      
		          ]],
		           view:detailview, 
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
					} ,

			toolbar:[
			         {
			        	 text:'修改',
			        	 iconCls:'icon-mini-edit',
			        	 handler:function(){
			        		 var s = $("#t").datagrid('getSelected');
			        		 if(s){
			        			 console.log(s);
			        			 for(i in s){
			        				 console.log(s[i])
			        			 }
			        			 $("#id2").val(s.id);
			        			 $("#title2").val(s.title);
			        			 $("#description2").val(s.description);
			        			 $("#createTime2").val(s.createTime);
			        			 $("#imag").val(s.img_path);
			        			 $("#image").prop('src','${pageContext.request.contextPath }/imgPath/'+s.img_path);
			        			 $("#updateFom").form({
			        				 url:'${pageContext.request.contextPath }/Banner/update.do',
			        				 onSubmit:function(){
			        					 //return $("#f").form('validate');
			        					 return true;
			        				 },
			        				 success:function(){
			        					// $('input').val("");
			        					 $("#updatePic").dialog('close');
			        					 $("#t").datagrid('reload');
			        					 //$("#t").panel('refresh','${pageContext.request.contextPath }/meun/selectAllObject.do?t=<%=request.getParameter("h") %>');
        				        		 $.messager.alert('提示信息','修改成功','ok');
			        				 }
			        			 }),
			        			 $("#updatePic").dialog({
			        				 title:'修改',
			        				 width:400,
			        				 height:500,
			        				 buttons:[
			        				          {
			        				        	  text:'提交',
			        				        	  iconCls:'icon-ok',
			        				        	  handler:function(){
			        				        		  $("#updateFom").submit();
			        				        	  }
			        				          }
			        				          ]
			        			 });
			        		 }else{
			        			 $.messager.alert('提示信息','请选中一行数据！~','warning');
			        		 }
			        	 }
			         },
			         {
			        	 text:'添加',
			        	 iconCls:'icon-add',
			        	 handler:function(){
			        			 $("#addFom").form({
			        				 url:'${pageContext.request.contextPath }/Banner/insert.do',
			        				 onSubmit:function(){
			        					 return true;
			        				 },
			        				 success:function(){
			        					  $("#addPic").dialog('close');
        				        		  $("#t").datagrid('reload');	
 			        					 //$("#t").datagrid('refresh','${pageContext.request.contextPath }/meun/selectAllObject.do?t=<%=request.getParameter("h") %>');
			        					  $('#title1').val("");
			        					  $('#description1').val("");
			        					  $('#createTime1').val("");
			        					  $('#img_path1').val("");
        				        		  $.messager.alert('提示信息','添加成功','ok');
			        				 }
			        			 }),
			        			// $("input").val("");
			        			 /* $("#s3").combobox({
		        						valueField:'cid',
		        						width:100,
		        						textField:'cname',
		        						url:'${path}/category/select.do?parentid=',
		        						onSelect:function(z){
		        							console.log(z);
		        							$("#s4").combobox({
				        						valueField:'cid',
				        						width:100,
				        						textField:'cname',
				        						url:'${path}/category/select.do?parentid='+z.cid,
				        						onLoadSuccess:function(f){
				        							$("#s4").combobox('select',f[0].cid);
				        						}
				        					});
		        						},
		        						onLoadSuccess:function(){
		        							$("#s3").combobox('select',1);
		        						}
		        					}); */
			        			 
			        			 $("#addPic").dialog({
			        				 title:'添加',
			        				 width:400,
			        				 height:500,
			        				 buttons:[
			        				          {
			        				        	  text:'提交',
			        				        	  iconCls:'icon-ok',
			        				        	  handler:function(){
			        				        		  $("#addFom").submit();
			        				        	
			        				        	  }
			        				          }
			        				          ]
			        			 });
			        	 }
			         },
			         {
			        	 text:'删除',
			        	 iconCls:'icon-cancel',
			        	 handler:function(){
			        		 var s = $("#t").datagrid('getSelections');
			        		 if(s){
			        			 console.log(s);
				        		 var arr=[];
				        		 for(i in s){
				        			 arr[i]=s[i].id;
				        		 }
				        		 console.log(arr);
				        		 /* $.post('${pageContext.request.contextPath }/Banner/delete.do','ss='+arr,function(){
 				        			// $("#t").empty();
				        			alert(123);
			        			 	$("#t").datagrid('reload');
			        			 	console.log(456);
			        			 	//$("#t").panel('refresh','${pageContext.request.contextPath }/meun/selectAllObject.do?t=<%=request.getParameter("h") %>');

				        		 }); 
				        		 */
				        		 
				        		 $.ajax({  
				        	            type: "post", 
				        	            url: '${pageContext.request.contextPath }/Banner/delete.do?ss='+arr, 
				        	            //data:"ss="+arr,  
				        	            success: function () {  
				        	                alert("success");
				        	                $("#t").datagrid('reload');
				        	            }, error: function () {  
				        	            	 $("#t").datagrid('reload');

				        	                //alert("error");  
				        	            }  
				        	        })
				        		/*  var ss = JSON.stringify(s);
								console.log(ss);
				        		 $.ajax({  
				        	            type: "post", 
				        	            url: '${pageContext.request.contextPath }/Banner/delete.do', 
				        	            data:JSON.stringify(s),  
				        	            contentType: "application/json; charset=utf-8",  
				        	            dataType: "json",
				        	            success: function () {  
				        	                alert("success");
				        	                $("#t").datagrid('reload');
				        	            }, error: function () {  
				        	                alert("error");  
				        	            }  
				        	        }) */
			        		 }else{
			        			 $.messager.alert('提示信息','请选中一行数据！~','warning');
			        		 }
			        	 }
			         },
			         ],
			         
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
	<table id="t"></table>
	     <div style="display:none;padding:30px " id="addPic">
       		<form id="addFom" method="post" enctype="multipart/form-data">
       			<table>
       				<tr>
       					<td>
			       			title ：
       					</td>
       					<td>
       						<input type="text" name="title" class="easyui-textbox" data-options="required:true,width:30px" value="" id="title1">
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			image ：
       					</td>
       					<td>
							<input type="file" name="up" id="img_path1" >
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			description ：
       					</td>
       					<td>
       						<input type="text" name="description" id="description1" class="easyui-textbox" data-options="required:true" value="">
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			show ：
       					</td>
       					<td>
       						<input type="radio" value="1" name="status" style="width: 20px;">true
		 					<input type="radio" value="0" name="status" checked style="width: 20px;">false
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			时间 ：
       					</td>
       					<td>
       						<input type="date" value="" name="createTime" id="createTime1">
       					</td>
       				</tr>
       			</table>
       		</form>
       </div>
       
       <div style="display:none;padding:30px " id="updatePic">
       		<form id="updateFom" enctype="multipart/form-data" method="post">
       			<table>
       				<input type="text" id="id2" name="id" value="" style="display:none">
       				<tr>
       					<td>
			       			title ：
       					</td>
       					<td>
       						<input type="text" id="title2" name="title" class="easyui-textbox" data-options="required:true,width:20px" value="">
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			image ：
       					</td>
       					<td>
       						<input type="hidden" name='img_path' id='imag'><br>
       						<img src="" id="image" style="width: 100px;"><br>
       						<!-- <input class="easyui-filebox" name="up" id="img_path2" data-options="required:true,accept:'image/jpeg'" value=""> -->
       						<input type="file" name="up" id="img_path2" >
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			description ：
       					</td>
       					<td>
       						<input type="text" name="description" id="description2" class="easyui-textbox" data-options="required:true" value="">
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			show ：
       					</td>
       					<td>
       						<input type="radio" value="1" name="status" style="width: 20px;" id="tru">true
		 					<input type="radio" value="0" name="status" checked style="width: 20px;" id="fal">false
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			时间 ：
       					</td>
       					<td>
       						<input type="date" value="" name="createTime" id="createTime2">
       					</td>
       				</tr>
       				
       			</table>
       		</form>
       </div>
</body> 
</html>