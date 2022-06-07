package com.goutham.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    @Pointcut("execution(* com.goutham.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.goutham.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.goutham.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(setter() || getter())")
    private void forDaoPackageNoGetSet(){}
    @Before("forDaoPackageNoGetSet()")
    public void performApiAnalytics(){
        System.out.println("performing analytics");
    }
}
