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
		
		$("#t1").treegrid({
			title:'专辑管理',
			idField:"id",
			//fit:true,
			singleSelect:false,
			treeField:"title",
			//loadMsg:'等着吧',
			url:'${pageContext.request.contextPath }/Album/select.do',
			columns:[[
		             {field:'title',width:200,title:'名称',align:'left',
		        	  halign:'center'},				      
		             {field:'size',width:200,title:'大小',align:'center',
		        	  halign:'center'},				      
		             {field:'createTime',width:200,title:'上传时间',align:'center',
		        	  halign:'center'},				      
		             {field:'url',width:200,title:'路径',align:'center',
		        	  halign:'center'},				      
		          ]],
		          toolbar:[
					         {
   						text:'专辑详情',
   						iconCls:'icon-tip',
   						handler:function(){
   							console.log(123);
   							//获得选中数据
    						var select = $('#t1').treegrid('getSelected'); 
   							console.log(324)
    						console.log(select);  						
    						if(select==null){
    							console.log(100);
    							$.messager.alert('提示','请选中您要查看的专辑行','warning');
    						}else{
    							console.log(10);
    							console.log(select._parentId)
    							if(select._parentId!=null){
    								select = $('#t1').treegrid('getParent',select.id)   ;
    								console.log(1);
    							}
    							console.log(select);
    							//document.getElementById("ImgAlbum").setAttribute("src","${path}/"+select.coverImg);
    							$("#ImgAlbum").prop("src","${pageContext.request.contextPath }/imgPath/"+select.coverimg);
    							console.log(2);
    							$('input,select,textarea',$('form[id="detailForm"]')).prop('readonly',true);
    							console.log(3)
    							$('#status').val(select.status);
    							var time = select.publicTime;   
    							$('#publicTime').prop("value",time);
    							console.log(4);
    							$('#detailForm').form('load',{
    								id:select.id,
									title:select.title,
									author:select.author,
									brodcast:select.brodcast,
									score:select.score,
									count:select.count,									
									brief:select.brief
    							});
    							console.log(1);
    							$('#dealbum').dialog({
									title:'专辑详情',
									width:500,
									height:600,
									buttons:[
										{
											text:'退出',
											iconCls:'icon-back',
											handler:function(){
												$('input,select,textarea',$('form[id="detailForm"]')).attr('readonly',false);
												$('#dealbum').dialog('close');
											}
										}
									]
								})
    						}	 
   						} 
   					},
					         {
					        	 text:'添加专辑',
					        	 iconCls:'icon-add',
					        	 handler:function(){
					        		 	/* $.ajax({
					        		 		type: "post", 
					        	            url: '${pageContext.request.contextPath }/Meun/selectClazz.do?t=Guru', 
					        	            success: function (result) {  
					        	            	console.log(result);
												for(i in j){
													$("#a1").append("<option>"+result[i].dharnaName+"</option>");
												}
					        	            }, error: function () {  
					        	            	 //$("#t1").datagrid('reload');
												alert(error);
					        	            }  
					        		 	}) */
					        		 	$.post("${pageContext.request.contextPath }/meun/selectClazz.do","t=Guru",function(result){
					        		 		for(i in result){
												$("#a1").append("<option value='"+result[i].id+"'>"+result[i].dharnaName+"</option>");
											}
					        		 	},"json");
					        			 $("#addFom").form({
					        				 url:'${pageContext.request.contextPath }/Album/insert.do',
					        				 onSubmit:function(){
					        					 return true;
					        				 },
					        				 success:function(){
					        					  $("#addPic").dialog('close');
		        				        		  $("#t1").treegrid('reload');	
					        					  $('#title1').val("");
					        					  $('#brodcast1').val("");
					        					  $('#brief1').val("");
					        					  $("#a2").empty();
		        				        		  $.messager.alert('提示信息','添加成功','ok');
					        				 },
					        				 error:function(){
					        					 $("#addPic").dialog('close');
		        				        		  $("#t1").treegrid('reload');	
					        					  $('#title1').val("");
					        					  $('#brodcast1').val("");
					        					  $('#brief1').val("");
					        					  $("#a2").empty();
		        				        		  $.messager.alert('提示信息','添加1成功','ok');
					        				 }
					        			 }),
					        			 
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
					        	 text:'添加音频',
					        	 iconCls:'icon-add',
					        	 handler:function(){
					        		 	$.post("${pageContext.request.contextPath }/meun/selectClazz.do","t=Album",function(result){
					        		 		for(i in result){
												$("#a2").append("<option value='"+result[i].id+"'>"+result[i].title+"</option>");
											}
					        		 	},"json")
					        			 $("#updateFom").form({
					        				 url:'${pageContext.request.contextPath }/Chapter/insert.do',
					        				 onSubmit:function(){
					        					 return true;
					        				 },
					        				 success:function(){
					        					  $("#updatePic").dialog('close');
		        				        		  $("#t1").treegrid('reload');	
					        					  $('#title2').val("");
					        					  $('#duration1').val("");
					        					  $("#a2").empty();
		        				        		  $.messager.alert('提示信息','添加成功','ok');
					        				 },
					        				 error:function(){
					        					 $("#updatePic").dialog('close');
		        				        		  $("#t1").treegrid('reload');	
					        					  $('#title2').val("");
					        					  $('#duration1').val("");
					        					  $("#a2").empty();
		        				        		  $.messager.alert('提示信息','添加1成功','ok');
					        				 }
					        			 }),
					        			 
					        			 $("#updatePic").dialog({
					        				 title:'添加',
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
					        	 }
					         },
					         {
			    					text:'下载音频',
			    					iconCls:'icon-undo',
			    					handler:function(){
			    						var select = $('#t1').treegrid('getSelected');   						
			    						if(select==null){
			    							$.messager.alert('提示','请选中您要下载的章节','warning');
			    						}else{
			    							if(select._parentId==null){
			    								 $.messager.alert('提示','请选中您要下载的章节信息','warning');   								
			    							}
			    							//url+"&groupName=" + encodeURI(encodeURI(select.url)) ;
			    							location.href="${pageContext.request.contextPath }/Album/download.do?path="+encodeURI(encodeURI(select.url));
			    						}
			    					},
			    					
			    				},
					         {
			    					text:'批量下载',
			    					iconCls:'icon-redo',
			    					handler:function(){
			    						var select = $('#t1').treegrid('getSelections');
			    						console.log(select);
			    						var selects=[];
			    						var index = 0;
			    						for(i in select){
			    							if(select[i]._parentId==null){
			    								var s = select[i].children;
			    								for(j in s){
			    									selects[index]=s[j].url;
			    									index++;
			    								}
			    							}else{
			    								selects[index]=select[i].url;
			    								index++;
			    							}
			    						} 
			    						console.log(selects);
			    						location.href="${pageContext.request.contextPath }/Album/downloads.do?selects="+selects;
			    					},
			    					
			    				}
					         ],
		});
	});
</script>
	<table id="t1"></table>
	<div id="z1">
		
	</div>
	     <div style="display:none;padding:30px " id="addPic">
       		<form id="addFom" method="post" enctype="multipart/form-data">
       			<table>
       				<tr>
       					<td>
			       			名称 ：
       					</td>
       					<td>
       						<input type="text" name="title" class="easyui-textbox" data-options="required:true,width:30px" value="" id="title1">
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			分数：
       					</td>
       					<td>
							<select id="s1" name="score">
       							<option>0</option>
       							<option>1</option>
       							<option>2</option>
       							<option>3</option>
       							<option>4</option>
       							<option>5</option>
       							<option>6</option>
       							<option>7</option>
       							<option>8</option>
       							<option>9</option>
       							<option>10</option>
       						</select>
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			波音：
       					</td>
       					<td>
       						<input type="text" name="brodcast" id="brodcast1" class="easyui-textbox" data-options="required:true" value="">
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			作者 ：
       					</td>
       					<td>
       						<select id="a1" name="id">
       						
       						</select>
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			简介 ：
       					</td>
       					<td>
       						<input type="text" value="" name="brief" id="brief1">
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			封面 ：
       					</td>
       					<td>
       						<input type="file" name="up" id="img1" >
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			状态 ：
       					</td>
       					<td>
       						<input type="radio" value="1" name="status" style="width: 20px;" id="tru">true
		 					<input type="radio" value="0" name="status" checked style="width: 20px;" id="fal">false
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
			       			名称 ：
       					</td>
       					<td>
       						<input type="text" id="title2" name="title" class="easyui-textbox" data-options="required:true,width:20px" value="">
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			音频路径 ：
       					</td>
       					<td>
       						<!-- <input type="hidden" name='img_path' id='imag'><br>
       						<img src="" id="image" style="width: 100px;"><br> -->
       						<!-- <input class="easyui-filebox" name="up" id="img_path2" data-options="required:true,accept:'image/jpeg'" value=""> -->
       						<input type="file" name="up" id="img_path2" >
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			所属文章：
       					</td>
       					<td>
       						<select id="a2" name="ext1">
       							
       						</select>
       					</td>
       				</tr>
       				<tr>
       					<td>
			       			时长：
       					</td>
       					<td>
       						<input type="text" value="" name="duration" id="duration1">
       					</td>
       				</tr>
       				<!-- <tr>
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
       				 -->
       			</table>
       		</form>
       </div>
       
       
       
       
       <div id="dealbum" style="display:none;">
  		<form id="detailForm" method="post" enctype="multipart/form-data">
  			<table > 				
  				<tr> 					
  					<td style="align:center">专辑名称：</td>
  					<td style="align:left">
  						<input id="id" name="id" type="hidden" value="id"/>
  						<input id="title" name="title" class="easyui-validatebox" data-options="required:true"/> 
  					</td>
  				</tr>
  				<tr> 					
  					<td style="align:center">作者：</td>
  					<td style="align:left">  						
  						<input id="author" name="author" class="easyui-validatebox" data-options="required:true"/> 
  					</td>
  				</tr>
  				<tr> 					
  					<td style="align:center">播音：</td>
  					<td style="align:left">  						
  						<input id="brodcast" name="brodcast" class="easyui-validatebox" data-options="required:true"/> 
  					</td>
  				</tr>				
 				<tr id="inputCB1" >
					<td><label>专辑图片 </label></td>
						<td>
							<input  mulitple style="width:300px"  name="fileput" class="easyui-filebox" data-options='onChange:change_photo'>
						</td>
					</tr>
					<tr id="inputCB4" >
					<td><label>图片预览</label></td>
					<td> <div id="ImgAlbumDiv"><img id="ImgAlbum"  width="200px" height="200px" src="" /></div></td>
				</tr>				 				
  				<tr>
					<td>
						详细描述：
	   				</td>
	   				<td>	   					
	   					<input  name="brief" id="brief" class="easyui-textbox" data-options="multiline:true,required:true,width:175,height:100"/>   						
	   				</td>
  				</tr> 
  				<tr> 					
  					<td style="align:center">集数：</td>
  					<td style="align:left">  						
  						<input id="count" name="count" class="easyui-numberbox" data-options="required:true" style="width:150px"/> 
  					</td> 
  				</tr>
  				<tr> 					
  					<td style="align:center">评分：</td>
  					<td style="align:left">  						
  						<input id="score" name="score" class="easyui-numberbox" data-options="required:true" style="width:150px"/> 
  					</td>
  				</tr>
  				<tr> 					
  					<td style="align:center">发布日期：</td>
  					<td style="align:left">  						
  						<input id="publicTime" type="text" data-options="required:true" style="width:150px"/> 
  					</td>
  				</tr>				
  				<tr>
  					<td style="align:center">状态</td>
  					<td style="align:left">
  						<select id="status" name="status">
  							<option value="1" selected>上载</option>
  							<option value="0">不上载</option>
  						</select>
  					</td>
  				</tr>				 			 
  			</table>
  		</form>
  	</div>
</body> 
</html>