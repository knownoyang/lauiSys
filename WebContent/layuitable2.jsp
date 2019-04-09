<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<title>layui</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<div class="demoTable">
  搜索名字：
  <div class="layui-inline">
    <input class="layui-input" name="id" id="demoReload" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload">搜索</button>
</div>



	<table class="layui-hide" id="test" lay-filter="test"></table>

	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
  </div>
</script>

	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


	<script src="layui/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

	<script>
		layui.use('table', function() {
			var table = layui.table;

			table.render({
				elem : '#test',
				url : 'users/list',
				toolbar : '#toolbarDemo',
				title : '用户数据表',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'userId',
					title : 'ID',
					width : 80,
					fixed : 'left',
					unresize : true,
					sort : true
				}, {
					field : 'userName',
					title : '用户名',
					width : 120,
					edit : 'text'
				}, {
					field : 'email',
					title : '邮箱',
					width : 150,
					edit : 'text',
					templet : function(res) {
						return '<em>' + res.email + '</em>'
					}
				}, {
					field : 'userSex',
					title : '性别',
					width : 80,
					edit : 'text',
					sort : true
				}, {
					field : 'userAddress',
					title : '地址',
					width : 100
				}, {
					field : 'userLevel',
					title : '等级',
					width : 100,
					templet : function(res) {
						return res.userLevel == 0 ? "管理员" : "普通用户";
					}
				}, {
					field : 'userTel',
					title : '电话',
					width : 80,
					sort : true
				}, {
					field : 'userState',
					title : '状态',
					width : 120,
					templet : function(res) {
						return res.userState == 0 ? "禁用" : "启用";
					}
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 150
				} ] ],
				page : true,
				id: 'testReload'
			});

			//头工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				switch (obj.event) {
				case 'getCheckData':
					var data = checkStatus.data;
					layer.alert(JSON.stringify(data));
					break;
				case 'getCheckLength':
					var data = checkStatus.data;
					layer.msg('选中了：' + data.length + ' 个');
					break;
				case 'isAll':
					layer.msg(checkStatus.isAll ? '全选' : '未全选');
					break;
				}
				;
			});

			//监听行工具事件
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				//console.log(obj)
				if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						//console.log(data); //得到的是当前行对应的数据信息
						console.log("userId :"+data.userId);						
						//将userId传递给控制器[Servlet]
						//servlet调用service执行删除动作  /users/del
						
						//ajax请求实现访问控制器
						$.post("users/del","userId="+data.userId,function(cm){
							
							layer.msg(cm.msg);
							obj.del(); //删除当前显示的行，前端界面上的删除
							layer.close(index);
						});
						
					});
				} else if (obj.event === 'edit') {
					layer.prompt({
						formType : 2,
						value : data.email
					}, function(value, index) {
						obj.update({
							email : value
						});
						layer.close(index);
					});
				}
			});
			
			/*表格数据重载 模糊检索*/
			var $ = layui.$, active = {
				    reload: function(){
				      var demoReload = $('#demoReload');
				      
				      //执行重载
				      table.reload('testReload', {
				        page: {
				          curr: 1 //重新从第 1 页开始
				        }
				        ,where: { //检索的条件
				        	//传递的参数 key为参数名 {} 内传递的是参数的值
				          /* key: {
				        	  
				            id: demoReload.val(),
				            username :....
				          } */
				          //只有一个key : value格式
				          content :demoReload.val()
				        }
				      });
				    }
				  };
				  
				  $('.demoTable .layui-btn').on('click', function(){
				    var type = $(this).data('type');
				    active[type] ? active[type].call(this) : '';
				  });
			
			
			
		});
	</script>

</body>
</html>