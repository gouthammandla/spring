package com.goutham.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("databaseFortuneService")
    private  FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "Practice The Cricket Daily ";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

   public TennisCoach(){
        System.out.println("Inside the tennis constructor");
   }
    /*@Autowired
    public void setFortuneService(FortuneService theFortuneService){
        System.out.println("TennisCoach : Inside  the setFortuneService()nmethod ");
        fortuneService=theFortuneService;
    }*/
}

