package com.sezeme.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.sezeme.common.JDBCTemplate.close;
import static com.sezeme.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args){
        Connection con = getConnection();
        /* PreparedStatement : 쿼리를 운반하고 결과를 반환하는 객체
        * 캐싱 처리 o, 미완성된 쿼리도 사용이 가능 */
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            /* 객체 생성 시 수행할 sql 구문을 설정해서 생성한다. */
            pstmt = con.prepareStatement("select * from employee");
            /* 셋팅된 상태에서 실행, 해당 함수에 인자 넣을 시 오류 발생하므로 구문을 전달하지 않는다. */
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.print(rset.getString("emp_name") + " ");
                System.out.println(rset.getInt("salary"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
