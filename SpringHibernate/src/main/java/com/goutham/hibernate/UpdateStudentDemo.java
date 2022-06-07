package com.goutham.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String args[]){


        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();


        // create object add java object to database
        try{

            session.beginTransaction();

            int studentId=1;

            session.getTransaction().commit();


            session=factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting student with id :"+studentId);
            Student myStudent=session.get(Student.class,studentId);
            System.out.println("Get complete :"+myStudent);
            System.out.println("updating student...");
            myStudent.setFirstName("scooby");
            session.getTransaction().commit();
            System.out.println("Done!");

            session=factory.getCurrentSession();
            session.beginTransaction();
             System.out.println("Updating all students email......");
             session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();

        }
        finally {

            factory.close();

        }
    }
}