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

	<div id="editFormDiv" style="display: none">
		<form class="layui-form" action="" lay-filter="example">

			<div class="layui-form-item">
				<label class="layui-form-label">用户编号</label>
				<div class="layui-input-block">
					<input type="text" name="userId" id="userId" name="userId"
						lay-verify="title" autocomplete="off" readonly class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-block">
					<input type="text" name="userName" id="userName" lay-verify="title"
						autocomplete="off" placeholder="请输入用户名" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">单选框</label>
				<div class="layui-input-block">
					<input type="radio" name="userSex" value="男" title="男" checked="">
					<input type="radio" name="userSex" value="女" title="女">
				</div>
			</div>


			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">地址</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" class="layui-textarea"
						name="userAddress" id="userAddress"></textarea>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">用户电话</label>
				<div class="layui-input-block">
					<input type="text" name="userTel" id="userTel" lay-verify="title"
						autocomplete="off" placeholder="手机号码" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">等级</label>
				<div class="layui-input-block">
					<select name="userLevel" lay-filter="aihao">
						<option value="0">管理员</option>
						<option value="1">普通用户</option>

					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">状态</label>
				<div class="layui-input-block">
					<select name="userState" lay-filter="aihao">
						<option value="1">启用</option>
						<option value="0">禁用</option>
					</select>
				</div>
			</div>


			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn btn-update" type="button" lay-submit=""
						lay-filter="demo1">立即提交</button>
				</div>
			</div>
		</form>
	</div>

	<div class="demoTable">
		搜索名字：
		<div class="layui-inline">
			<input class="layui-input" name="id" id="demoReload"
				autocomplete="off">
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
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="resetpwd">重置密码</a>
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
					width : 200
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
					width : 180,
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
					width : 250
				} ] ],
				page : true,
				id : 'testReload'
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
						console.log("userId :" + data.userId);

						//将userId传递给控制器[Servlet]
						//servlet调用service执行删除动作  /users/del

						//ajax请求实现访问控制器
						$.post("users/del", "userId=" + data.userId, function(
								cm) {

							layer.msg(cm.msg);
							if (cm.msg == "删除成功") {
								obj.del(); //删除当前显示的行，前端界面上的删除
								layer.close(index);
							}
						});

					});
				} else if (obj.event === 'edit') {

					//先给我们的表单元素赋值
					$("#userId").attr("value", data.userId);
					$("#userName").attr("value", data.userName);
					console.log($("#userName").val());
					$("#userTel").attr("value", data.userTel);
					//性别

					if (data.userSex === "女") {
						$("input[name='userSex'][value='女']").prop("checked",
								true);
					}
					else
						{
						$("input[name='userSex'][value='男']").prop("checked",
								true);
						}
					/* if (data.userSex == "女") {
						$("input[name='userSex'][value='女']").attr("checked",
								true);
						$("input[name='userSex'][value='男']").attr("checked",
								false);
						//$('input:radio[name=userSex]')[1].checked = true;
					} else {
						$("input[name='userSex'][value='男']").attr("checked",
								true);
						$("input[name='userSex'][value='女']").attr("checked",
								false);
						//$('input:radio[name=userSex]')[0].checked = true;

					} */
					layui.form.render('radio');

					//地址文本域 <textarea> 文字....</textarea>
					$("#userAddress").html(data.userAddress);

					//等级

					layer.open({
						type : 1//弹出层 div
						,
						area : [ '600px', '500px' ],
						shade : 0.6,
						id : 'LAY_layuipro' //设定一个id，防止重复弹出
						,
						//content : $("#editFormDiv").html(),
						content : $("#editFormDiv"), //后面不用.html()

					});

					//表单的render
					layui.form.render();

					/* layer.prompt({
						formType : 2,
						//value : data.userName //.email
						value : JSON.stringify(data)
					}, function(value, index) {
						obj.update({
							email : value
						});
						layer.close(index);
					}); */
				}
			});

			/*表格数据重载 模糊检索*/
			var $ = layui.$, active = {
				reload : function() {
					var demoReload = $('#demoReload');

					//执行重载
					table.reload('testReload', {
						page : {
							curr : 1
						//重新从第 1 页开始
						},
						where : { //检索的条件
							//传递的参数 key为参数名 {} 内传递的是参数的值
							/* key: {
							  
							  id: demoReload.val(),
							  username :....
							} */
							//只有一个key : value格式
							content : demoReload.val()
						}
					});
				}
			};

			$('.demoTable .layui-btn').on('click', function() {
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});

			/*修改 表单的提交 按钮的单击事件 ，监听1 */
			$(document).on("click", ".btn-update", function() {
				//可以实现 比较麻烦....
				console.log(layui.form.data);
			});

			//监听提交  新增加的代码  监听2
			layui.form.on('submit(demo1)', function(data) {
				/* layer.alert(JSON.stringify(data.field), {
					title : '最终的提交信息'
				}) */
				//表单中的数据 进行转换，得到一个json格式的字符串
				console.log(JSON.stringify(data.field));
				//ajax请求实现访问控制器
				$.ajax({
					type : "post", //提交方式
					url : "users/update",
					data : JSON.stringify(data.field), //提交给控制器的数据
					contentType : "application/json", //提交给控制的数据 格式
					success : function(cm) {
						layer.msg(cm.msg, {
							time : 2000
						//两秒延迟
						}, function() {
							if (cm.msg == "修改成功") {

								//obj.update(); ?? 理想
								//layer.close(index);;
								parent.layer.closeAll();//关闭所有,简单粗暴
								window.parent.location.reload();//刷新父页面
							}

						});

					}
				});

				return false;
			});

		});
	</script>

</body>
</html>