package vn.techmaster.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.techmaster.thymeleaf.model.Book;
import vn.techmaster.thymeleaf.model.Student;

@Controller
@RequestMapping("")
public class HomeController {
    @GetMapping("/hello")
    public String homePage(){
        return "index";
    }
    @GetMapping("/book")
    @ResponseBody
    public Book returnBook(){
        return new Book("De men phieu luu ki","To Hoai");
    }
    @GetMapping(value="/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Book returnBookXML() {
      return new Book("De men phieu luu ky", "To Hoai");
    }
    @GetMapping("/book-html")
    public String returnBookhtml(Model model){
      model.addAttribute("book", new Book("De mem phieu luu ki","To Hoai"));
        return "book";
    }
    @GetMapping("/student")
    public String returnStudent(Model model){
      List<Student> students= new ArrayList<Student>();
      students.add(new Student("Khiem","A"));
      students.add(new Student("Long","B"));
      model.addAttribute("students", students);
      model.addAttribute("message", "<h1>hello</h1>");

    return "student";
    }
  }

