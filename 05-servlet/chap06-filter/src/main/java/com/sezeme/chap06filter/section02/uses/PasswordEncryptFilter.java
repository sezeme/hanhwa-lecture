package com.sezeme.chap06filter.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;


@WebFilter(value = "/member/*")
public class PasswordEncryptFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Member 와 관련 된 기능은 해당 필터를 거치게 되고 ServletRequest 를 감까는 Wrapper
        // 객체로 변경하여 Request 객체를 전달 받게 된다.
        System.out.println("PasswordEncryptFilter 동작");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);
        filterChain.doFilter(requestWrapper, servletResponse);
    }
}
