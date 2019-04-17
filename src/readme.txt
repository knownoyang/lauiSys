2019年4月17日09:13:35
将之前查询[翻页]功能，进行改写，主要的变化是后台[控制器以及service dao等java核心代码]变了;
后台: springmvc来做控制器，支持rest风格
             数据访问[持久化]： spring-jdbc
             控制器写好可以使用postman来测试      
             
前台:界面的部分已经完整，只需要修改请求的接口路径就可以

后台的操作步骤:
①准备支持spring springmvc springjdbc jackson mysqlconnector 等
②配置文件:applicationContext.xml springmvc-servlet.xml web.xml
③UsersDaoImpl ：dao的实现类需要依赖jdbcTemplate来完成数据访问操作,请见UsersDaoImpl
④单元测试: 使用junit进行测试，看结果正常，继续写service和Controller 
⑤postman进行接口的测试[控制器测试]
⑥编码jsp页面，完成请求操作;处理响应结果.
页面请见:layuitable2.jsp





