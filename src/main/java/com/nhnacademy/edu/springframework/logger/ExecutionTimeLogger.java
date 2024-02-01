package com.nhnacademy.edu.springframework.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

//@Aspect
//@Component
public class ExecutionTimeLogger {

//    @Around("execution(* com.nhnacademy.edu.springframework.messagesender.sender.MessageSender.sendMessage(..))")
    public Object printExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(ExecutionTimeLogger.class);

        StopWatch stopWatch = new StopWatch("ExecutionLogger");
        stopWatch.start();

        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            stopWatch.stop();
//            System.out.println(stopWatch.prettyPrint());
            String className = joinPoint.getTarget().getClass().getSimpleName();
            String methodName = joinPoint.getSignature().getName();
            String logMessage = String.format("%s.%s %s", className, methodName, stopWatch.getTotalTimeMillis() + "ms");

            System.out.println(logMessage);
        }
    }

}
