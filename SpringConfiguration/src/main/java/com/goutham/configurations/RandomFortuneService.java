package com.goutham.configurations;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class RandomFortuneService implements  FortuneService {

    private String[] data = {"Hi" , "Good Morning"};
    private Random r = new Random();

    @Override
    public String getFortune() {
        int index = r.nextInt(data.length);
        return data[index];
    }
}