package org.apache.ibatis.debug;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author kenny
 * @date 2022-01-11
 */
public class DebugMain {

    public static void main(String[] args) throws Exception {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 读取配置文件，构建 Configuration
        //从 XML 中构建 SqlSessionFactory
        // DefaultSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.select(1L);
        System.out.println(user);

        // 查询第二次，验证缓存
        user = mapper.select(1L);
        System.out.println(user);

        session.close();
    }
}
