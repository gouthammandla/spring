package com.goutham.springMvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController{

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        theModel.addAttribute("student",new Student());
        return "student-form";
    }
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent)
    {
        System.out.println(theStudent.getFirstName()+" "+theStudent.getLastName());
             return "student-confirmation";

    }
}
