package bitlab.springtask3_1.Controllers;

import bitlab.springtask3_1.Models.DBManager;
import bitlab.springtask3_1.Models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String index (Model model){
        ArrayList<Student> students = DBManager.getStudents();
        model.addAttribute("students",students);
        return "/index";
    }

    @GetMapping(value = "/addStudents")
    public String addItem(){
        return "/addStudent";
    }

    @PostMapping(value = "/addStudents")
    public String addStudent(@RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname,
                             @RequestParam(name = "exam") int exam
                             ){

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        DBManager.addStudent(student);
        return "redirect:/";

    }


}
