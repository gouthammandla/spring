package com.goutham.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class HelloSpringApp {
    public static void main(String[] args)
    {

        //load spring configuration file
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve beans from spring container
        Coach theCoach=context.getBean("myCoach", Coach.class);
        //call methods on bean
        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());
        //close the context
        context.close();
    }
}
