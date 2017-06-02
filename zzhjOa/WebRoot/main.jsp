<%@ page language="java" import="java.util.*,com.zzhj.po.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="common.jsp" %>

<!DOCTYPE HTML">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>中兆恒基Oa办公系统</title>
<!-- <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page"> -->
	<script type="text/javascript">
		
		//websocket实例
		var ws;
		$(function(){
			 $("#message").hide(); 
			 //查询公告
 			 $.post("notice/queryAll.action",function(data){
				 for (var i = 0; i < data.length; i++) {
					 $("#north").append("<p style='overflow: hidden; '><a href='notice/queryOne.action?id="+data[i].id+"'  target='notice/showNotice.jsp'>"+"《主题》："+data[i].theme+"&nbsp;&nbsp;《发布时间》："+data[i].releaseDate+"&nbsp;&nbsp;《发布人》:"+data[i].userId.name+"</a></p>") 
				}
				 
			 }) 
			 
			//--------webSocket----------
            if ("WebSocket" in window){
            	alert("您的浏览器支持webScoket");
               // 打开一个 web socket
                ws = new WebSocket("ws://localhost:8080/zzhjOa/serverHandler");
				
               ws.onopen = function()
               {
                  // Web Socket 已连接上，使用 send() 方法发送数据
               /*    ws.send("发送数据"); */
               alert("已链接webSocket服务器，牵手成功")
               };
				
               ws.onmessage = function (evt) 
               { 
                  var msg = evt.data;
                  var jsonObject =JSON.parse(msg);
              	  $("#message").show();
                  $("#listMes").append("<li>"+jsonObject.theme+"————发起人————"+jsonObject.from+"</li>")
                  var audioEle = document.getElementById("audio");
      			  audioEle.play();
               };
				
               ws.onclose = function()
               { 
                  // 关闭 websocket
                  alert("webscoet关闭")
               };
            }
            
            else
            {
               // 浏览器不支持 WebSocket
               alert("您的浏览器不支持 WebSocket!");
            }
			
			
			/* --echats */
			 var myChart = echarts.init(document.getElementById('zhu'));
		        var option = {
		                title: {
		                    text: '数据展示'
		                },
		                tooltip: {},
		                legend: {
		                    data:['销量']
		                },
		                xAxis: {
		                    data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
		                },
		                yAxis: {},
		                series: [{
		                    name: '销量',
		                    type: 'bar',
		                    data: [5, 20, 36, 10, 10, 20]
		                }]
		            };

		            // 使用刚指定的配置项和数据显示图表。
		            myChart.setOption(option);
		            //
		            var bing = echarts.init(document.getElementById('bing'));
		           var bingOption = {
		            	    series : [
		            	        {
		            	            name: '访问来源',
		            	            type: 'pie',
		            	            radius: '55%',
		            	            roseType: 'angle',
		            	            data:[
		            	                {value:235, name:'视频广告'},
		            	                {value:274, name:'联盟广告'},
		            	                {value:310, name:'邮件营销'},
		            	                {value:335, name:'直接访问'},
		            	                {value:400, name:'搜索引擎'}
		            	            ]
		            	        }
		            	    ]
		            	};
		           bing.setOption(bingOption);
			//end  -----
			
			
			/* $("#mainTree").tree({
				url:'function/getNode.action',
				loadFilter:function(data){
					for(var i = 0; i < data.length;i++){
		  				data[i].attributes = {'url':data[i].url};
		  			}
		  			return data;
				},
			 	dnd:false,
			    animate:true,
			    lines:true,
			    onClick:function(node){
			    	addTab(node.text,node.url);
				}
			}); */
			
			//手风琴开始
			$.post('function/getNode.action',function(data){
					for(var i = 0; i < data.length;i++){
		  				$('#parent').accordion('add', {  
                            title : data[i].text,
                            selected:false,
                            iconCls:data[i].icon,
                            content :"<div style='padding-left:50px;'><ul name="+data[i].text+" param="+data[i].id+"></ul></div>",  
                        });  
		  			}
			});
			
		$('#parent').accordion({  
            onSelect : function(title, index) { 
            	var param =$("ul[name='" + title + "']").attr("param");
                 $("ul[name='" + title + "']").tree({  
                    url : '${pageContext.request.contextPath}/function/getNode.action',  
                    queryParams : {  
                        id : param
                    }, 
                    lines : true,//显示虚线效果     
                    onClick: function(node){// 在用户点击一个子节点即二级菜单时触发addTab()方法,用于添加tabs  
                        if(node.url){//判断url是否存在，存在则创建tabs  
                            addTab(node.text,node.url);  
                        }  
                    }  
                });    
          	}
          }); 
          //手风琴结束

		});
		///
	  	function addTab(tab,url){
	  		if(!$("#mytabs").tabs('exists',tab) && url !=""&&url!=null){
	  			$("#mytabs").tabs('add',{
	  	  			title:tab,
	  	  			href:url,
	  	  			closable:true
	  	  		}) ;
	  			
	  		}
	  		else{
	  			$("#mytabs").tabs('select',tab) ;
	  		}
	  	}
		
		function exit(){
			 $.post("users/exit.action",function(data){
				location.href=data;
			}); 
		}
		
		function mes(){
		 	$('#mesDd').dialog({
				width : 400,
				height : 300,
				modal : true, 
				title : '查看未处理信息',
				closed : false,
				onClose:function(){
					$("#listMes").empty();
					$("#message").hide();
				}
			});  
			
		}
		

		
		
	</script>
	
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/parent.css">
  </head>
	<body>   
    	<div id="cc" class="easyui-layout" fit=true "style="height:70px;"> 
    	<audio src="mp3/4331.mp3" id="audio"></audio>
    	<!-- 上侧 -->
    	<div data-options="region:'north'" style="height:80px;/* background-color: E0ECFF; */background-color: gray; " id="title" >
    		<a href="#" class="logo_btn"><img src="image/logo_02.png"/></a>
    		<span class="main_span">中兆恒基Oa办公系统</span>
    	 	<div id="message" > 
    			<p id="mgeTitle"  onclick="mes()">你有未处理的消息<img src="image/lb.png" style="vertical-align: middle; margin-left:15px;"></p>
    		</div>
			<div id="user">
				<ul style="position: relative;">
				<p style=" position: absolute; left:-20px; top:-15px;"> <img alt="" src="image/2017-05-24_145120.png" width="50px;" style="border-radius:25px;"></p>
					<li><h3>当前用户:${users.name }</h3></li>
					<li><h4>${message }</h4></li>
					<li><h4 onclick="exit()" style="cursor:pointer">退出登陆</h4></li>
				</ul>
			</div>
    	</div>      
    	<!-- 左侧 -->
    	<div id="parent" data-options="region:'west',title:'菜单栏',split:true" style="width:280px;" class="easyui-accordion">
    		 <!-- 	<ul id='mainTree'></ul>	  -->
    	</div>  
    	<!-- 右侧 --> 
    	<div data-options="region:'center',title:'窗口'" style="background:#eee;">
    		<div id="mytabs" class="easyui-tabs" fit=true >   
				   <div title="首页" style="background-color: white;">
				   	<div id="tianQi">
						<iframe name="weather_inc" src="http://i.tianqi.com/index.php?c=code&id=2&num=5" width="650" height="70" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
					</div>
				   	<div id="echart">
				   		<div id="zhu" style="width: 400px; height: 200px; padding: 10px; margin-left: 20px;"></div>
				   		<div id="bing" style="width: 400px; height: 220px; padding: 10px; margin-left: 20px; "></div>
				   	</div>
				   	<div id="notice">
				   		 <div id="north" style="overflow: auto;">
				   			<img src="image/gg.png" width="100%"/>
				   		</div> 
				   		<div id="south">
				   			 <iframe src="date.html" width="100%" height="100%" frameborder="0" ></iframe> 
				   		</div>
				   		
				   	</div>
				   	<iframe src="http://news.szhk.com/" width="100%" height="100%" frameborder="0" ></iframe>
				   </div>   
			</div> 
			<div id="mesDd"  class="easyui-dialog" closed=true >
				<ul id="listMes"></ul>
			</div> 
    	</div>   
		</div>  
	</body>  
</html>
