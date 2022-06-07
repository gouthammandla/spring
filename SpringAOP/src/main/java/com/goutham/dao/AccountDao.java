package com.goutham.dao;

import com.goutham.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao {
    private String name;
    private String serviceCode;

    public void addAccount(Account account,boolean flag){
        System.out.println(getClass()+":doing my work");
    }
    public boolean doWork(){
        System.out.println(getClass()+":do work()");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+":in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+":in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+":in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+":in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public List<Account> findAccounts(boolean tripWire){
        List<Account> myAccounts=new ArrayList<>();
        Account temp1=new Account("john","Silver");
        Account temp2=new Account("Madhu","Platinum");
        Account temp3=new Account("Luca","Gold");
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        return myAccounts;
    }

}
