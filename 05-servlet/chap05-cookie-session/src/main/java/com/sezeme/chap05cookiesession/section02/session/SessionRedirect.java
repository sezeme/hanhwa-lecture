package com.sezeme.chap05cookiesession.section02.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/session-redirect")
public class SessionRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* session id를 통해 session 인스턴스를 가져온다. */
        HttpSession session = req.getSession();
        System.out.println("redirect session id : " + session.getId());

        /* 세션 인스턴스에 저장 된 attribute 는 다른 요청에서 꺼내 쓸 수 있다. */
        String firstName = (String) session.getAttribute("firstName");
        String lastName = (String) session.getAttribute("lastName");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h1> your firstName is " + firstName + " and lastName is " + lastName + "</h1>");
        out.flush();
        out.close();

    }
}
