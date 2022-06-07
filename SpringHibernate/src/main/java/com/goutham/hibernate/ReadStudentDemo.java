package com.goutham.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {
    public static void main(String args[]){


        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();


        // create object add java object to database
        try{

            System.out.println("Creating a new student object");
            Student tempStudent =new Student("Duffy","duck","Duffy@gamil.com");


            session.beginTransaction();

            session.save(tempStudent);
            System.out.println("saving the new student object");
            System.out.println(tempStudent);

            session.getTransaction().commit();
            System.out.println("Saved student id: "+tempStudent.getId());

            session=factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting student with id :"+tempStudent.getId());
            Student myStudent=session.get(Student.class,tempStudent.getId());
            System.out.println("Get complete :"+myStudent);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {

            factory.close();

        }
    }
}