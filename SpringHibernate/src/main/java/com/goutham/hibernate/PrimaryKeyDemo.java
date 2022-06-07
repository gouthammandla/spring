package com.goutham.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args)
    {
        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();

        try{

            System.out.println("Creating a new student object");
            Student tempStudent1 =new Student("goutham","reddy","goutham@gamil.com");
            Student tempStudent2=new Student("vishal","reddy","vishal@gamil.com");


            session.beginTransaction();

            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("saving the new student object");

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {

            factory.close();

        }

    }
}
