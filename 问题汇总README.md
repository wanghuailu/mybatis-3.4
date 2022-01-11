1、修改配置信息为jdk8、
    File -> Project Structure -> Project Settings -> Project
    File -> Project Structure -> Project Settings -> Modules -> （需要修改的工程名称） -> Sources -> Language Level 
    File -> Setting -> Build,Execution,Deployment -> Compiler -> Java Compiler

2、数据库信息
    mybatis-config.xml

3、创建表
    user表，两个字段 id、name
    
4、执行 DebugMain 的 main 方法