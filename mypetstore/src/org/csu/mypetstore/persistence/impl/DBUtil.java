package org.csu.mypetstore.persistence.impl;

import java.sql.*;

/**
 * Created by jinyejun on 5/10/15.
 */
public class DBUtil {
    private final static String DRIVE_NAME = "com.mysql.jdbc.Driver";
    private final static String CONNECTION = "jdbc:mysql://127.0.0.1:3306/mypetstore";
    private final static String USERNAME = "root";
    private final static String PASSWORD  = "root";

    public static Connection getConnection() throws Exception {
        Class.forName(DRIVE_NAME);
        Connection connection = DriverManager.getConnection(CONNECTION,USERNAME,PASSWORD);
        return connection;
    }

    public static void closeConnection(Connection connection) throws Exception{
        if(connection != null){
            connection.close();
        }
    }

    public static void closeStatement(Statement statement) throws Exception{
        if(statement != null){
            statement.close();
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws Exception {
        if(preparedStatement != null){
            preparedStatement.close();
        }
    }

    public static void closeResultSet(ResultSet resultSet) throws Exception{
        if(resultSet != null){
            resultSet.close();
        }
    }


}
