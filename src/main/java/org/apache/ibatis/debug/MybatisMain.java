package org.apache.ibatis.debug;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author kenny
 * @date 2022-01-11
 */
public class MybatisMain {

    public static void main(String[] args) throws Exception {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 读取配置文件，构建 Configuration
        // 从 XML 中构建 SqlSessionFactory
        // DefaultSqlSessionFactory
        // 构建者模式
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 默认开启一个事务，但是不会自动提交该事务
        // 在执行增删改操作的时候，需要手动提交事务 sqlSession.commit()
        // 如果不想手动提交，可以 sqlSessionFactory.openSession(true)
        SqlSession session = sqlSessionFactory.openSession();

        // mybatis 代理方式实现 DAO 层的开发
        // 使用 JDK 动态代理对 mapper 接口产生代理对象
        UserMapper mapper = session.getMapper(UserMapper.class);

        PageHelper.offsetPage(0, 10);

        // 如何匹配到 xml
        // xml 配置了 namespace，这个需要跟类的全路径限定名一致
        // 同时 xml 的 id 和 方法名也必须是一致的
        // 这就规定了，mapper 文件不支持类的重载
        // 调用 MapperProxy 的 invoke 方法
        User user = mapper.select(1L);
        System.out.println(user);

        mapper.update(1L, user.getAge() + 1);

//        session.commit();

        // 查询第二次，验证缓存
        user = mapper.select(1L);
        System.out.println(user);

        session.close();
    }
}
