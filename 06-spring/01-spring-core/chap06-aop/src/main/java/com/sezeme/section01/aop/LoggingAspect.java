package com.sezeme.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // Aspect(분리 된 횡단 관심사) : Point-cut + Advice (부가 코드)
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.sezeme.section01.aop.*Service.*(..))")
    public void logPointCut() {
    }

    // Advice (부가 코드)

    // Before : 핵심 기능 수행 전 동작
    @Before("LoggingAspect.logPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        // JoinPoint : 포인트 컷으로 패치한 실행 시점으로 메소드명, 인수 값 등의 정보에 접근 가능
        System.out.println("before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("before joinPoint.getSignature() : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {
            System.out.println("before joinPoint.getArgs[0] : "
                    + joinPoint.getArgs()[0]);
        }
    }

    // After : 핵심 기능 수행 후 동작
    @After("logPointCut()") // 같은 클래스인 경우 클래스명 생략 가능, 다른 패키지인 경우 패키지명까지 기술
    public void logAfter(JoinPoint joinPoint) {
        // JoinPoint : 포인트 컷으로 패치한 실행 시점으로 메소드명, 인수 값 등의 정보에 접근 가능
        System.out.println("After joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) {
            System.out.println("After joinPoint.getArgs[0] : "
                    + joinPoint.getArgs()[0]);
        }
    }
}


