package com.goutham.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
    public boolean addMe(){
        System.out.println(getClass()+":Adding membership account");
        return true;
    }
    public void goToSleep(){
        System.out.println(getClass()+":go to sleep");
    }
}
