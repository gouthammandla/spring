package com.goutham.springDemo;

public class CricketCoach implements Coach{
    private FortuneService fortuneService;
    private String email;
    public CricketCoach(){
           System.out.println("CricketCoach:Inside no-arg constructor");
    }
    public void setFortuneService(FortuneService theFortuneService)
    {
        this.fortuneService=theFortuneService;
        System.out.println("CricketCoach:Inside the setter method");
    }

    public void setEmail(String theEmail)
    {
        this.email=theEmail;
        System.out.println(email);
    }

    @Override
    public String getDailyWorkout() {
        return "Practice bowling for 15 min daily";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
