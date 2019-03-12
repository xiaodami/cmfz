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
<script type="text/javascript">
	<!--菜单处理-->
	$(function(){
		/* $('#aa').accordion('add',{ 
			title:'213',
		    animate:false,
		    fit:true,
		    
		});   */
		$.post("${pageContext.request.contextPath }/meun/selectByParentId.do",pid=null,function(relust){
			for(i in relust){
				var z = relust[i].id;
				$('#aa').accordion('add',{ 
					id:relust[i].id,
					title:relust[i].title,
					collapsed:true,
				    fit:true,
				    selected:false,
				    content:"<div id='"+relust[i].id+"'></div>",
				    onExpand:function(){
				    	console.log(this.id);
				    	var zz= this.id;
				    	$.post("${pageContext.request.contextPath }/meun/selectByParentId.do",'pid='+zz,function(r){
				    		console.log(zz);
				    		console.log(r)
				    		if(r!=null){
					    		for(j in r){
					    			console.log(r[j].href);
						    		$("#"+zz).append("<a id='"+zz+""+r[j].id+"' href='#' onclick='f1("+'"'+r[j].href+'","'+r[j].title+'"'+")'>"+r[j].title+"</a>");
					    		}
				    		}
				    	},"json")
				    },
				    onCollapse:function(){
				    	console.log(123456)
				    	$("#"+this.id).empty();
				    }
				    
				});
			}
		},"json");
		
	})
	
	function f1(href,tit){
		console.log(href);
		console.log(tit);
		/* $.post("${pageContext.request.contextPath }/meun/selectAllObject.do","t="+href,function(relust){
			console.log(relust);
			console.log(tit); */
			addTab({
				title:tit,
				href:data.jsp,
				index:1,
				
				
			})/*  ;
		},"json"); */
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
	
	
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:xxxxx &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
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
</body> 
</html>