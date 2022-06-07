package com.goutham.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {
    public static void main(String args[]){


        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();


        // create object add java object to database
        try{

            System.out.println("Creating a new student object");
            Student tempStudent =new Student("goutham","reddy","goutham@gamil.com");
            Student tempStudent1 =new Student("john","doe","goutham@gamil.com");


            session.beginTransaction();

            session.save(tempStudent);
            session.save(tempStudent1);
            System.out.println("saving the new student object");

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {

            factory.close();

        }
    }
}