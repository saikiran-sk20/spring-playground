package com.example.demo;

/**
 * Created by saseri on 7/6/2017.
 */
import java.lang.String;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*@RequestMapping("/app")*/
public class EndpointsController {

    @GetMapping("/math/pi")
    public String piValue(){
        return "3.141592653589793" ;

    }
 @PostMapping("/")
    public String postEggs(){
        return "New eggs!";

 }

}
