package com.sezeme.section01.xmlconfig;

import com.sezeme.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext(
                        "section01/xmlconfig/spring-context.xml"
        );

//        MemberDTO member = (MemberDTO) applicationContext.getBean("member");
//        MemberDTO member = applicationContext.getBean(MemberDTO.class);
        MemberDTO member = applicationContext.getBean("member", MemberDTO.class);

        System.out.println(member);
    }
}
