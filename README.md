部署文档
——JudgeMind
一、系统概述
本项目是一个支持多语言在线编程与判题的OJ系统，具备题目管理、用户管理、代码提交、异步判题、代码沙箱安全执行等功能。系统采用前后端分离架构，后端为单体Spring Boot应用，支持Docker部署。

二、环境要求
环境	版本/要求
操作系统	Linux（推荐Ubuntu 20.04+）
Java	8或11
Node.js	16或18
Docker	20.10+
MySQL	5.7/8.0
Redis	6.0+（用于Session存储）

三、部署系统
3.1服务部署清单
服务名称	英文名	端口号	版本号	服务类别
数据库	mysql	3306	v8	环境依赖
缓存	redis	6379	v6	环境依赖
消息队列	rabbitmq	5672,
15672	v3.12.6	环境依赖
注册中心	nacos	8848	v2.2.0	环境依赖
网关服务	gateway	8101	java 8	业务服务
用户服务	yuoj-backend-user-service	8102	java 8	业务服务
题目服务	yuoj-backend-question-service	8103	java 8	业务服务
判断服务	yuoj-backend-judge-service	8104	java 8	业务服务
3.2 从附录的github地址拉取代码	
3.3加载maven项目
在项目根目录执行
mvn package
或者通过maven插件实现打包操作
3.4通过Docker Compose文件启动
先启动环境依赖配置
后启动业务服务配置

四、附录
[前端项目地址](judgeMind:judgeMind在线判题系统（前端）)
后端调试的接口文档地址是localhost:8101/doc.html
[代码沙箱项目地址]liyiyi66/oj-code-sandbox
