package com.sezeme.chap04forwardredirect.section02.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/otherservlet")
public class OtherServletRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 비즈니스 로직 수행 후 */
        System.out.println("get 요청 정상 수락 후 응답");
        resp.sendRedirect("redirect");
    }
}
