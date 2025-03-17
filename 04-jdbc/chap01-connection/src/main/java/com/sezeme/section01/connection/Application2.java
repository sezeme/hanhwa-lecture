package com.sezeme.section01.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/* DB와 연결 합니당 */
public class Application2 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        Connection con = null;
        try {
            properties.load(
                    new FileReader(
                            "src/main/java/com/sezeme/section01/connection/jdbc-config.properties"
                    )
            );

            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            /* 설정 정보는 유지보수성을 위해 리터럴 값으로 작성하지 않고 별도의 파일로 분리한다. */

            con = DriverManager.getConnection(
                    url, user, password
//                    url, properties
            );
            System.out.println("con = " + con);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
