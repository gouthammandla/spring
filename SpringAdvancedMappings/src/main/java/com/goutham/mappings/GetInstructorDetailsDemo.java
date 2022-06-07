package com.goutham.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorDetailsDemo {
    public static void main(String args[]){


        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();


        // create object add java object to database
        try{
            session.beginTransaction();
            int theId=29;
            InstructorDetail tempID=session.get(InstructorDetail.class,theId);
            System.out.println(tempID);
            System.out.println("the associated instructor "+tempID.getInstructor());


            session.getTransaction().commit();
            System.out.println("Done!");
        }catch(Exception exc)
        {
            exc.printStackTrace();
        }
        finally {
             session.close();
            factory.close();

        }
    }
}