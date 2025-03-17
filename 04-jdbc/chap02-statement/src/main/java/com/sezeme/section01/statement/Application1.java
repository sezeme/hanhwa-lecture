package com.sezeme.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.sezeme.common.JDBCTemplate.close;
import static com.sezeme.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        try {
            /* Statement : 쿼리를 운반하고 그 결과를 반환하는 객체 */
            stmt = con.createStatement();
            /* ResultSet : Statement 객체를 통해 조회 처리 된 결과를 다루는 객체, 포인터 형식 */
            rset = stmt.executeQuery("SELECT * FROM employee");

            while (rset.next()) {
                System.out.print(rset.getString("emp_name") + " ");
                System.out.println(rset.getInt("salary"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);

        }
    }
}
