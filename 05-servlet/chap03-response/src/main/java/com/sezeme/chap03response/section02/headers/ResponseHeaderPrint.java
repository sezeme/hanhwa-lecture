package com.sezeme.chap03response.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(value = "/headers")
public class ResponseHeaderPrint extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
//        resp.setHeader("Refresh", "1");

        long currentTime =System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<head>")
                .append("<title>응답 페이지</title>")
                .append("</head>")
                .append("<body><h1>")
                .append(currentTime)
                .append("</h1></body>")
                .append("</html>");

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(sb);
        printWriter.flush();
        printWriter.close();

        /* response header 정보 */
        Collection<String> responseHeaders = resp.getHeaderNames();
        for(String headerName : responseHeaders) {
            System.out.println(headerName);
        }
    }
}
