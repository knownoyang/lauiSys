<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layui/css/layui.css" media="all">
</head>
<body>
<table id="demo" lay-filter="test"></table>
 
<script src="layui/layui.js"></script>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 560
    ,url: 'users/list' //数据接口 ,暂时使用layui提供的接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {field: 'userId', title: '编号', width:80, sort: true, fixed: 'left'}
      ,{field: 'userName', title: '用户名', width:80}
      ,{field: 'userPwd', title: '密码', width:180, sort: true}
      ,{field: 'userSex', title: '性别', width:80} 
      ,{field: 'userTel', title: '电话号码', width: 177}
      ,{field: 'userAddress', title: '地址', width: 380, sort: true}
      ,{field: 'userLevel', title: '等级', width: 80, sort: true}
      ,{field: 'userState', title: '状态', width: 80}
    ]]
  });
  
});
</script>
</body>
</html>
