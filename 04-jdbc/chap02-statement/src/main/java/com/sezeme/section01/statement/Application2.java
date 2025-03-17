package com.sezeme.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.sezeme.common.JDBCTemplate.*;

/* 사번을 Scanner로 입력 받아서 사원의 정보를 출력하는 프로그램
 * 사원의 정보 : emp_id, emp_name, salary
 * 없는 사번이면 "해당 사원의 조회 결과가 없습니다." 출력
 * */
public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("조회하고 싶은 사번 : ");
        int empId = sc.nextInt();


        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT emp_id, emp_name, salary FROM employee WHERE emp_id=" + empId);

            if(rset.next()){ //next로만 사용해야함.
                System.out.print(rset.getString("emp_id") + " ");
                System.out.print(rset.getString("emp_name") + " ");
                System.out.println(rset.getInt("salary"));
            } else{
                System.out.println("해당 사원의 조회 결과가 없습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(stmt);
            close(rset);
            close(con);
        }
    }
}
