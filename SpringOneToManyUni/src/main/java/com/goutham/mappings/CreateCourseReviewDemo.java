package com.goutham.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseReviewDemo {
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
            Course theCourse=new Course("Spring");
            theCourse.addReview(new Review("great Course loved it."));
            theCourse.addReview(new Review("Cool Course"));
            theCourse.addReview(new Review("Bad one"));
            System.out.println("Saving the course");
            System.out.println(theCourse);
            System.out.println(theCourse.getReviews());
            session.save(theCourse);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();

            factory.close();

        }
    }
}