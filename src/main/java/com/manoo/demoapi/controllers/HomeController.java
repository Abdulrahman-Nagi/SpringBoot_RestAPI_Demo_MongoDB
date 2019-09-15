package com.manoo.demoapi.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/")
    public String greeting() {

        return "Hello ya 3am";
    }


    @GetMapping(value = "/{name}")
    public String greetingName(@PathVariable String name) {

        return "Hello : "+name;
    }



}
