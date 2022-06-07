package com.goutham.dao;


import com.goutham.Account;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
    AccountDao dao=context.getBean("accountDao",AccountDao.class);
    List<Account> theAccounts=null;
    


}
