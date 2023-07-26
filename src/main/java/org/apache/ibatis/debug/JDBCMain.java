package org.apache.ibatis.debug;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author kenny
 * @date 2023-07-25
 */
public class JDBCMain {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
            preparedStatement.setLong(1, 1L);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
