package com.goutham.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesToMaryDemo {
    public static void main(String args[]){


        SessionFactory factory =new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();


        // create object add java object to database
        try{




            session.beginTransaction();
            int theId=2;
            Student theStudent=session.get(Student.class,theId);
            System.out.println("courses....."+theStudent.getCourses());

            Course tempCourse1=new Course("ReactJS");
            Course tempCourse2=new Course("NodeJS");
            tempCourse1.addStudent(theStudent);
            tempCourse2.addStudent(theStudent);
            System.out.println("Saving the courses");
            session.save(tempCourse1);
            session.save(tempCourse2);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();

            factory.close();

        }
    }
}