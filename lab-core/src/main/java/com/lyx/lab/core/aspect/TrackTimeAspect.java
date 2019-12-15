package com.lyx.lab.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 跟踪方法调用耗时的切面
 */
@Aspect
@Component
@Slf4j
public class TrackTimeAspect {

    @Around("@annotation(com.lyx.lab.core.aspect.TrackTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object obj = joinPoint.proceed();
        stopWatch.stop();
        log.info("Time Taken by {} is {} ms", joinPoint, stopWatch.getTotalTimeMillis());
        return obj;
    }

}
