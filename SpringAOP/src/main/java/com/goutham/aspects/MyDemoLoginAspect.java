package com.goutham.aspects;

import com.goutham.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.nio.channels.AcceptPendingException;
import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {
    @Pointcut("execution(* com.goutham.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.goutham.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.goutham.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(setter() || getter())")
    private void forDaoPackageNoGetSet(){}
    @Before("forDaoPackageNoGetSet()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("Excecuting before addAccount() method");
        MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();
        System.out.println(methodSignature);
        Object[] args=theJoinPoint.getArgs();
        for(Object temp:args)
        {
            System.out.println(temp);
        }
    }
    @Before("forDaoPackageNoGetSet()")
    public void performApiAnalytics(){
        System.out.println("performing analytics");
    }
    @Before("forDaoPackageNoGetSet()")
    public void LogToCloudAsync(){
        System.out.println("Logging to cloud");
    }

    @AfterReturning(pointcut = "execution(* com.goutham.dao.AccountDao.findAccounts(..))",returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){
   String method=theJoinPoint.getSignature().toShortString();
   System.out.println("After returning from method:"+method);
   System.out.println(result);
    }

}
