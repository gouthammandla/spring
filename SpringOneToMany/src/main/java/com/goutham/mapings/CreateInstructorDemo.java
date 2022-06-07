package com.goutham.mapings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {
    public static void main(String args[]){


        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();


        // create object add java object to database
        try{


            Instructor tempInstructor1=new Instructor("susan", "patel","asusan@gmail.com");
            InstructorDetail tempInstructorDetail1=new InstructorDetail("http://w3schools.com","gaming");

            tempInstructor1.setInstructorDetail(tempInstructorDetail1);



            session.beginTransaction();

            System.out.println("Saving Instructor......"+tempInstructor1);

            session.save(tempInstructor1);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();

            factory.close();

        }
    }
}