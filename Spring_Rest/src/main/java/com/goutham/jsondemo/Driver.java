package com.goutham.jsondemo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args)
    {
        try{
            ObjectMapper mapper=new ObjectMapper();
            Student theStudent=mapper.readValue(new File("data/sample-full.json"),Student.class);
            System.out.println(theStudent.getFirstName());
            System.out.println(theStudent.getLastName());
            Address theAddress=theStudent.getAddress();
            System.out.println(theAddress.getCity());
            for(String tempLang:theStudent.getLanguages()){
                System.out.println(tempLang);
            }

        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
}
