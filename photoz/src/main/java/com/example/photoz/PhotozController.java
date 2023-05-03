package com.example.photoz;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@RestController
public class PhotozController {

    private List<Photo> db = List.of(new Photo("1","hello.jpg"));


    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/photoz")
    public List<Photo> get(){
        return db;
    }
}
