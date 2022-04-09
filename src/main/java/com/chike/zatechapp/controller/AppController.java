package com.chike.zatechapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/")
    public String ping(){
        return  "Hello World";
    }

    @GetMapping("/swapi/people")
    public String getSwapi(){
        return  "Hello World";
    }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query){
        return  "Hello World";
    }

}
