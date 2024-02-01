package com.nhnacademy.edu.springframework.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//@Aspect
//@Component
public class ExecutionTimeLogger {

//    @Around("execution(* com.nhnacademy.edu.springframework.messagesender.sender.MessageSender.sendMessage(..))")
    public Object printExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch("ExecutionLogger");
        stopWatch.start();

        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

}
