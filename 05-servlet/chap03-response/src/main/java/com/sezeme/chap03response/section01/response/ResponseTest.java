package com.sezeme.chap03response.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/response")
public class ResponseTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 1. 요청(req)을 받아서 처리한다. => req.getParameter()
        * 2. 비즈니스 로직을 처리한다. => DB 접속 및 CRUD 로직 수행
        * 3. 응답(resp)을 처리한다.
        * => resp 이용해서 동적인 웹(HTML 문서) 페이지를 만들고 스트림을 이용해 내보낸다.
        * */

        /* 문자열을 이용해 사용자에게 내보내질 페이지 작성 */
        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<head>")
                .append("<title>응답 페이지</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>안녕 Servlet Response</h1>")
                .append("</body>")
                .append("</html>");

        resp.setContentType("text/html"); // 응답 데이터의 MIME type 설정
        resp.setCharacterEncoding("UTF-8"); // 응답 데이터의 문자 셋 설정

        resp.setContentType("text/html; charset=UTF-8"); // 위의 두 가지 설정을 한 번에

        /* tomcat 10 버전 이상 부터는 MIME type만 기재해도 문자 셋이 자동으로 utf-8 설정 */
        resp.setContentType("text/html");

        // 사용자 브라우저에 응답하기 위한 출력 스트림을 resp 에서 반환 받는다.
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(sb);
        printWriter.flush();
        printWriter.close();
    }
}
