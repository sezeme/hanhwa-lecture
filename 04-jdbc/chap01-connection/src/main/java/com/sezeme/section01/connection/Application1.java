package com.sezeme.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* DB와 연결 합니당 */
public class Application1 {
    public static void main(String[] args) {
        /* 작성해야 하는 url이 정해져있다.
        * localhost : ip
        * 3306: 포트번호 */
        Connection con = null;
        try {
            /* DB 연결 정보가 잘못 작성 된 경우 Connection 객체 생성이 불가능하므로
            * SQLException이 발생할 수 있다.*/
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "practice", "practice");
            System.out.println("con = " + con);
            // con = com.mysql.cj.jdbc.ConnectionImpl@65d09a04 -> implement여서 impl, 실제로 구현하고 있는 것은 외부 라이브러리이다.
            // DriverManager에서 connection의 구현체 생성
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // connection도 열었으면 무조건 닫아주어야 함.
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
