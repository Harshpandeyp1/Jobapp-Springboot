package com.prj.job.app.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class Validation {
    private static Logger LOGGER = LoggerFactory.getLogger(Validation.class);

    @Around("execution(* com.prj.job.app.service.JobService.getJob(..))&&args(PostId)")
    public Object Validate(ProceedingJoinPoint jp,int PostId) throws Throwable {


        LOGGER.info("PostId is -ve");
        if(PostId<0){
            PostId=-PostId;
            LOGGER.info("new value"+PostId);
        }
       Object obj= jp.proceed(new Object[]{PostId});

        return obj;
    }


}
