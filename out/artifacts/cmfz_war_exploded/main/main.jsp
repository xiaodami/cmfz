<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="../js/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../js/themes/icon.css">   
<script type="text/javascript" src="../js/jquery.min.js"></script>   
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script> 
<script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script type="text/javascript" src="/cmfz_lwl/js/echarts.js"></script>
<script type="text/javascript" src="https://www.echartsjs.com/gallery/vendors/echarts/map/js/china.js?_v_=1548453451319"></script> 
<script type="text/javascript">
	$(function(){
		
		$.post("${pageContext.request.contextPath }/meun/selectByParentId.do",pid=null,function(relust){
			for(i in relust){
				$('#aa').accordion('add',{ 
					id:relust[i].id,
					title:relust[i].title,
					collapsed:true,
					iconCls:relust[i].iconcls,
				    fit:true,
				    selected:false,
				    content:"<div  id='"+relust[i].id+"'></div>",
				    onExpand:function(){
				    	var zz= this.id;
				    	$.post("${pageContext.request.contextPath }/meun/selectByParentId.do",'pid='+zz,function(r){
				    		if(r!=null){
					    		 for(j in r){
					    			 console.log(r[j].href);
						    		//$("#"+zz).append("<a id='"+zz+""+r[j].id+"' href='#'  class='easyui-linkbutton l-btn l-btn-small' data-options='plain:false,width:200,iconCls:"+'"'+r[j].iconcls+'"'+"' onclick='f1("+'"'+r[j].href+'","'+r[j].title+'"'+")'><span class='l-btn-left l-btn-icon-right'>"+r[j].title+"<span class='l-btn-icon icon-add'> </span></span></a>");
					    			 $("#"+zz).append("<a id='"+zz+""+r[j].id+"' href='#' onclick='f1("+'"'+r[j].href+'","'+r[j].title+'"'+")'>"+r[j].title+"</a>");
					    			 $("#"+zz+r[j].id).linkbutton({
					    				 iconCls: r[j].iconcls,
					    				 //fit:true,
					    				 height:30,
					    				 inline:true,
					    			 });
					    		} 
				    		}
				    	},"json");
				    },
				    onCollapse:function(){
				    	$("#"+this.id).empty();
				    }
				    
				});
			}
		},"json");
		
	});
	
	function f1(href,tit){
		console.log(href);
		console.log(tit);
		/* $.post("${pageContext.request.contextPath }/meun/selectAllObject.do","t="+href,function(relust){
			console.log(1111)
		},"json") */
		addTab({
			title:tit,
			closable:true,
			href:href+".jsp?h="+href,
			index:1,
		});
	}
	function addTab(options){
				// 判断是否存在添加的新选项卡
				if(!$('#tt').tabs('exists',options.title)){
					// 执行添加
					$('#tt').tabs('add',options);
				}else{
					// 选中对应选项卡
					$('#tt').tabs('select',options.title);
				}
			}
	function updatePass(){
		$("#updatePassword").dialog({
			title:"修改密码",
			closable:true,
			buttons:[{
						text:"提交",
			         	handler:function(){
			         		$.post("${pageContext.request.contextPath }/Admin/change.do","password1="+$("#p1").val()+"&password2="+$("#p2").val(),function(result){
			         			if(result!=""){
				         			$("#updatePassword").dialog("close");
				         			$.messager.alert('提示信息','修改成功','ok');
				         			$("#p1").val("");
				         			$("#p2").val("");
			         			}else{
			         				$.messager.alert('提示','密码有误,请重新输入','warning');
			         				$("#p1").val("");
				         			$("#p2").val("");
			         			}
			         		})
			         	}
					}
			         	
			         ],
		})
	}
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.name } &nbsp;<a href="#" onclick="updatePass()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/Admin/logout.do" id="logout" onclick="logout()" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div> 
    <div style="display:none;" id="updatePassword">
    	<form>
		    <table id="ttt" >
		    	<tr>
		    		<td>账号：</td>
		    		<td>${sessionScope.admin.name }</td>
		    	</tr>
		    	<tr>
					<td>请输入原密码：</td>
		    		<td><input type="password" name="password1" id="p1"></td>
		    	</tr>
		    	<tr>
		    		<td>请输入新密码：</td>
		    		<td><input type="password" name="password2" id="p2"></td>
		    	</tr>
		    </table>  
    	</form>
    </div>
</body> 
</html>