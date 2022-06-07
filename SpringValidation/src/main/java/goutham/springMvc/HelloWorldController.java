package goutham.springMvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }
    @RequestMapping("/processFormTwo")
    public String processFormTwo(HttpServletRequest Request, Model model)
    {
        String theName=Request.getParameter("studentName");
        theName=theName.toUpperCase();
        String result="Yo! "+theName;
        model.addAttribute("message",result);
        return "helloworld";
    }
    @RequestMapping("processFormThree")
    public String processFormThree(@RequestParam("studentName") String theName, Model model)
    {
        theName=theName.toUpperCase();
        String result="Hey! "+theName;
        model.addAttribute("message",result);
        return "helloworld";
    }
}
