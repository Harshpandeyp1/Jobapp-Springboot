package com.prj.job.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class Logging {


    private static Logger LOGGER= LoggerFactory.getLogger(Logging.class);

    //return type,class name.method name,(args)
    @Before("execution(* com.prj.job.app..*(..)) && !within(com.prj.job.app.aop..*)")
    public void LogMethod(){
         LOGGER.info("method called");



         //this is used for specific method call
//        @Before("execution(* *.getJob(..))")
//        public void LogMethod(JoinPoint jp){
//            LOGGER.info("method called"+jp.getSignature().getName());


    }
    @After("execution(* com.prj.job.app..*(..)) && !within(com.prj.job.app.aop..*)")
    public void LogMethodExected() {
        LOGGER.info("method called");

        //after throwing will only work if the method have some exception and after returning wil work after the excepptiom is solved
    }

}


