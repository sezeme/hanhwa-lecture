package com.sezeme.section03.proxy.subsection02.cglib;

import com.sezeme.section03.proxy.common.OhgiraffersStudent;
import com.sezeme.section03.proxy.common.Student;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) {

        /* 2. CGLib Proxy 방식
        * Target Object의 타입이 Class 여도 가능하다. */
        OhgiraffersStudent student = new OhgiraffersStudent();
        Handler handler = new Handler(student);

        OhgiraffersStudent proxy
                = (OhgiraffersStudent) Enhancer.create(OhgiraffersStudent.class, handler);
        proxy.study(12);
    }
}
