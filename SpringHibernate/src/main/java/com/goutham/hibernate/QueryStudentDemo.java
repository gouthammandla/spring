package com.goutham.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String args[]){


        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();


        // create object add java object to database
        try{

            session.beginTransaction();
            List<Student> theStudents=session.createQuery("from Student").getResultList();
            dispalyStudents(theStudents);
            theStudents=session.createQuery("from Student s where s.lastName='Doe'").getResultList();
            System.out.println("Students whose last name Doe is : ");
            dispalyStudents(theStudents);

            theStudents=session.createQuery("from Student s where"+" s.lastName='Doe' OR s.firstName='goutham'").getResultList();
            dispalyStudents(theStudents);

            session.getTransaction().commit();
        }
        finally {

            factory.close();

        }
    }

    private static void dispalyStudents(List<Student> theStudents) {
        for(Student tempStudent: theStudents)
        {
            System.out.println(tempStudent);
        }
    }
}