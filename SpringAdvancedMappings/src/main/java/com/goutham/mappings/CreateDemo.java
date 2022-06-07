package com.goutham.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
    public static void main(String args[]){


        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();


        // create object add java object to database
        try{


            Instructor tempInstructor1=new Instructor("akhil", "reddy","akhil@gmail.com");
            InstructorDetail tempInstructorDetail1=new InstructorDetail("http://youtube.com","reading");

            tempInstructor1.setInstructorDetail(tempInstructorDetail1);



            session.beginTransaction();

            System.out.println("Saving Instructor......"+tempInstructor1);

            session.save(tempInstructor1);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {

            factory.close();

        }
    }
}