package com.goutham.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {
    public static void main(String args[]){


        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();


        // create object add java object to database
        try{

            session.beginTransaction();

            int studentId=2;

            session.getTransaction().commit();


            session=factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting student with id :"+studentId);
            Student myStudent=session.get(Student.class,studentId);
            System.out.println("Get complete :"+myStudent);
            System.out.println("Deleting student...");
            //session.delete(myStudent);

            System.out.println("Done!");
            System.out.println("Deleting a student.....");
            session.createQuery("delete from Student where id=3").executeUpdate();
            session.getTransaction().commit();

        }
        finally {

            factory.close();

        }
    }
}