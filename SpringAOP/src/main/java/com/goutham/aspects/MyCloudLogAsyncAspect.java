package com.goutham.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
    @Pointcut("execution(* com.goutham.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.goutham.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.goutham.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(setter() || getter())")
    private void forDaoPackageNoGetSet(){}

    @Before("forDaoPackageNoGetSet()")
    public void LogToCloudAsync(){
        System.out.println("Logging to cloud");
    }
}
