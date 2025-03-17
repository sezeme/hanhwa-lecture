package com.sezeme.section01.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.sezeme.common.JDBCTemplate.close;
import static com.sezeme.common.JDBCTemplate.getConnection;


public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into " +
                "tbl_menu(menu_name, menu_price, category_code, orderable_status) " +
                "values(?,?,?,?)";
        int result = 0;
        try {
            pstmt = con.prepareStatement(sql);

            // 홀더 타입과 테이블 컬럼 타입이 다르면 오류가 난다.
            pstmt.setString(1, "봉골레청국장");
            pstmt.setInt(2, 12000);
            pstmt.setInt(3, 4);
            pstmt.setString(4, "Y");

            // insert, update, delete 시에는 수행된 행의 개수를 int로 반환
            // executeUpdat()로 호출
            result = pstmt.executeUpdate();

            if(result > 0) {
                con.commit();
            } else {
                con.rollback();
            }
            // Q.근데 autocommit 켜있지 않나?
            System.out.println("insert 결과 : " + result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }
    }
}
