package com.store.Store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/")
    public String getHome(){
        return "Hello World!";
    }

    @GetMapping("/test")
    public String getTest(){
        return "Test";
    }

    @GetMapping("/person")
    public Person getPerson(){
        Person p = new Person();
        p.setName("Kevin");
        p.setAge(10);
        return p;
    }
}


class Person {

    private String name;
    private int age;

    // public Person(String name, int age){
    //     this.name = name;
    //     this.age = age;
    // }

    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
}