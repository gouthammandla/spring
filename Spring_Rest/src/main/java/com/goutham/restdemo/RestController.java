package com.goutham.restdemo;

import com.goutham.entity.Students;
import com.goutham.jsondemo.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private List<Students> theStudents;
    @PostConstruct
    public void loadData(){
         theStudents=new ArrayList<>();
        theStudents.add(new Students("poornima","patel"));
        theStudents.add(new Students("Goutham","reddy"));
        theStudents.add(new Students("Rohith","Rathod"));

    }
    @GetMapping("/students")
    public List<Students> getStudents() {

        return theStudents;
    }
    @GetMapping("/students/{studentId}")
    public Students getStudent(@PathVariable int studentId)
    {

        if((studentId>=theStudents.size())||studentId<0)
        {
            throw new StudentNotFoundException("Student did not found..."+studentId);
        }
        return theStudents.get(studentId);
    }


}
