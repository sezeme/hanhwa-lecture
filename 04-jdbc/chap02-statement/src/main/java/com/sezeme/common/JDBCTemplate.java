package com.sezeme.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/* 이후에 JDBC 관련 코드들이 반복적으로 호출 될 예정이므로 Utiol용으로 JDBCTemplate 클래스를 작성한다. */
public class JDBCTemplate {

    public static Connection getConnection() {
        Properties properties = new Properties();
        Connection con = null;
        try {
            properties.load(new FileReader("src/main/java/com/sezeme/config/jdbc-config.properties"));
            String url = properties.getProperty("url");
            con = DriverManager.getConnection(url, properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    /* Connection을 닫는 개념은 별도의 메소드로 분리하고 실제 닫는 시점은 Service 계층에서 진행 */
    public static void close(Connection con) {
        try {
            if(con != null & !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        try {
            if(stmt != null & !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rset) {
        try {
            if(rset != null & !rset.isClosed()) {
                rset.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}