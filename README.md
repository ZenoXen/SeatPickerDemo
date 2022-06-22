# SeatPickerDemo
一个简易图书馆选座系统，大学时做的SSM练手项目，前端页面是缝合怪

## 使用说明
Idea项目，把文件作为新项目导进去即可，依赖用的是pom。后端用的是SSM，没用Spring Boot，所以配置比较杂乱。前端页面只有少量html+css+js是自己写的，是Bootstrap加上其他人写的页面的缝合怪，看起来比较奇怪。功能不算多，自己玩一遍就会了，数据库相关信息在db.properties里，修改成自己的即可。

## 关于数据库表结构
应issue的建议，时隔两年，第一次更新了这个项目；可以使用main/resource目录下的tables.sql文件，生成这个项目的表结构。为了方便自己添加数据，建议在admins表中添加一条记录，即初始管理员账号，可以用于登录后台模块，用以管理楼层、座位等。

## 运行指南
1. 修改db.properties文件，将数据库信息改成自己的，注意该项目使用的database名字叫seat
2. 使用tables.sql文件，生成表结构；可以考虑在admins表内，插入一条记录，方便登录管理系统
3. 项目打成war包放到tomcat ROOT目录下，或者使用idea来部署到tomcat，注意application context必须是/
4. 打开localhost:8080，可以看到主页

## 其他
请不要吐槽我的Java和数据库命名规范为什么这么混乱...因为那时候真的啥也不会，写的所有东西都乱七八糟的。如果发现什么bug或者有啥建议，都可以在issue里提，我会尽量改进
