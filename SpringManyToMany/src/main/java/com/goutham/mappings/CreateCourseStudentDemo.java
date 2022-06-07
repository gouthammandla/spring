package com.goutham.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseStudentDemo {
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
            Course tempCourse=new Course("Security");

            System.out.println("Saving the course");
            session.save(tempCourse);
            System.out.println("Saved the Course...."+tempCourse);
            Student tempStudent1=new Student("john","Doe","John@gmail.com");
            Student tempStudent2=new Student("mary","Public","mary@gmail.com");
            Student tempStudent3=new Student("tom","Public","tom@gmail.com");
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);
            tempCourse.addStudent(tempStudent3);
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            System.out.println("Saved students..."+tempCourse.getStudents());


            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();

            factory.close();

        }
    }
}