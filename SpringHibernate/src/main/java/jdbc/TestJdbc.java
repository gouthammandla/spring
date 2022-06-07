package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args)
    {
        String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSl=false&serverTimezone=UTC";
        String user="goutham";
        String pass="Goutham@123";
        try{
            System.out.println("Connecting to database");
            Connection myConnection= DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection Successful");

    }
    catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
}
