package com.goutham.springDemo;

public class BaseBallCoach implements Coach {
    private FortuneService fortuneService;
    public BaseBallCoach(FortuneService theFortuneService)
    {
        fortuneService=theFortuneService;
    }
    public BaseBallCoach(){

    }
    @Override
    public String getDailyWorkout() {
        return "Spend 30 min on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}