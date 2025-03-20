package com.sezeme.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

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

    // AfterReturning : 메소드 정상 수행 후 반환할 경우 반환값을 가공해서 전달
    @AfterReturning(value = "logPointCut()", returning = "result")
    public void logAfterReturn(JoinPoint joinPoint, Object result) {
        // JoinPoint : 포인트 컷으로 패치한 실행 시점으로 메소드명, 인수 값 등의 정보에 접근 가능
        System.out.println("after returning result : " + result);
//        if (result instanceof Map) {
//            System.out.println("After joinPoint.getArgs[0] : "
//                    + joinPoint.getArgs()[0]);
//        }
    }

    // AfterThrowing : 메소드 정상 수행 후 반환할 경우 반환값을 가공해서 전달
    @AfterThrowing(value = "logPointCut()", throwing = "exception")
    public void logAfterThrow(JoinPoint joinPoint, Exception exception) {
        // JoinPoint : 포인트 컷으로 패치한 실행 시점으로 메소드명, 인수 값 등의 정보에 접근 가능
        System.out.println("after exception result : " + exception);
    }

    // Around : 핵심 기능 시작과 끝을 감싸고 동작
    @Around(value = "logPointCut()")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before : " + joinPoint.getSignature());

        Object result = joinPoint.proceed(); // 원본 조인 포인트를 실행하는 코드

        System.out.println("around after : " + joinPoint.getSignature());
    }
}


