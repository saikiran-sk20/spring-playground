package com.example.demo;

/**
 * Created by saseri on 7/6/2017.
 */
import java.lang.String;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloworld(){
        return "cracked eggs!" ;

    }


}
