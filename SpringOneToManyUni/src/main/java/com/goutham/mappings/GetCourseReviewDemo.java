package com.goutham.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetCourseReviewDemo {
    public static void main(String args[]){


        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();


        // create object add java object to database
        try{




            session.beginTransaction();
            int theId=10;
            Course theCourse=session.get(Course.class,theId);
            System.out.println(theCourse);
            System.out.println(theCourse.getReviews());
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();

            factory.close();

        }
    }
}