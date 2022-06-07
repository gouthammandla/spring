package com.goutham;

import com.goutham.dao.AccountDao;
import com.goutham.dao.DemoConfig;
import com.goutham.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAppDemo {
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDao dao=context.getBean("accountDao",AccountDao.class);
        MembershipDao membershipDao=context.getBean("membershipDao",MembershipDao.class);
        Account account=new Account();
        dao.addAccount(account,true);
        dao.setName("hari");
        dao.setServiceCode("silver");
        String name=dao.getName();
        String code=dao.getServiceCode();
        dao.doWork();
        membershipDao.addMe();
        membershipDao.goToSleep();
        context.close();
    }
}
