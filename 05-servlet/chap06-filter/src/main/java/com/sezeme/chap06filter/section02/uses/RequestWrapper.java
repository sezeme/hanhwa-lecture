package com.sezeme.chap06filter.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /* 비밀번호와 관련된 속성 파라미터를 꺼낼 때 암호화를 적용할 확장 된 메소드 */
    @Override
    public String getParameter(String name) {
        String value = "";
        if("password".equals(name)){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter(name));
        } else {
            value = super.getParameter(name);
        }
        return value;
    }
}
