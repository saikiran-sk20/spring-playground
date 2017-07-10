package com.example.demo;

/**
 * Created by saseri on 7/6/2017.
 */
import java.lang.String;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
/*@RequestMapping("/app")*/
public class EndpointsController {

    @GetMapping("/query/test")
    public String queryValue(@RequestParam Map querystring){
        return querystring.toString();
   /* public String piValue(@RequestParam String type,@RequestParam String id){
        return String.format("type is: %s and id is: %s",type,id) ;*/

    }
 @PostMapping("/")
    public String postEggs(){
        return "New eggs!";

 }

}
