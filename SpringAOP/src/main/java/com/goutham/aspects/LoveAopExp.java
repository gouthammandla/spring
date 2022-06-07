package com.goutham.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoveAopExp {
    @Pointcut("execution(* com.goutham.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.goutham.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.goutham.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(setter() || getter())")
    private void forDaoPackageNoGetSet(){}
}
