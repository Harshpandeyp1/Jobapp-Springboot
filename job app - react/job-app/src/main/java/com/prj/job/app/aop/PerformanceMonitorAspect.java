package com.prj.job.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


//Around will print the statement before and After
@Component
@Aspect
public class PerformanceMonitorAspect {

    private static Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.prj.job.app.service.JobService.getJob(..))")
    public Object Monitor(ProceedingJoinPoint jp) throws Throwable {
        long start=System.currentTimeMillis();

        Object obj=jp.proceed();


        long end=System.currentTimeMillis();

        LOGGER.info("time taken:"+(end-start));
        return obj;
    }
}
