package com.sezeme.chap06filter.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/* web.xml(배포 서술자)를 통해 필터를 등록할 수 있다. 초기화 값 설정 가능 */
public class EncodingFilter implements Filter {
    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Encoding Filter 동작");
        // POST 방식의 요청이 오면 문자 셋을 설정하는 전처리 작업
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if ("POST".equals(request.getMethod())) {
            servletRequest.setCharacterEncoding(encodingType);
        }
        // 전처리 된 req 객체를 다음 필터 또는 서블릿으로 넘김
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
