package com.sezeme.chap01lifecycle.section03.servicemethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 해당 클래스를 servlet으로 등록시키는 annotation
@WebServlet(value = "/request-service")
public class ServiceMethodTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        String httpMethod = req.getMethod();
        System.out.println("httpMethod : " + httpMethod);

        if("GET".equals(httpMethod)) {
            doGet(req, resp);
        } else if("POST".equals(httpMethod)){
            doPost(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 방식의 요청 처리 메소드");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 방식의 요청 처리 메소드");
    }
}
