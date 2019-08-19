2018年10月30日 16:39:32 项目状态 - 已测试生成成功：
1. 使用MybatisGenerator生成ORM对象的路径是：项目/mybatisGenerator/src/com/xdf/femisnsb
	分别在dao、mapper、model。生成后要手动拷贝到项目的对应的包下
2. 其中mapper下的xml文件要拷贝到：项目/src/main/java/resources/mapper下 - 配置文件是指向该文件夹的。

当前项目状态：
	整合SSM，已测试MybatisGenerator
	解决返回json中文乱码的问题 - jsp页面中文也正常
	

2018年10月31日 10:55:16
	之前的版本中mybatis和mybatis-spring的版本不兼容，没有测试到，此时已经测试通过，
	网上查询获取到的兼容版本是：
	mybatis = 3.3.1      匹配   mybatis-spring = 1.1.1
	mybatis = 3.4.0      匹配   mybatis-spring = 1.3.1
	
	
2018年12月3日 14:47:39	
	整合shiro完成，认证测试通过，权限也测试通过，没有权限时依然返回JsonData给前端
	