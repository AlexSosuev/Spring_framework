package ru.gb.example3_sem4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String helloWorld(){
        return "Hello";
    }
}
