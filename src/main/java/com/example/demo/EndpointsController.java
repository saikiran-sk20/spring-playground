package com.example.demo;

/**
 * Created by saseri on 7/6/2017.
 */
import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Length;

import java.util.Map;


@RestController
@RequestMapping("/math")
public class EndpointsController {

@Autowired
private MathService mathService;

    @RequestMapping("/volume/{length}/{breath}/{height}")
    public String vol(@PathVariable String length,@PathVariable String breath,@PathVariable String height){
     String calculateVol= mathService.volume(length,breath,height);
     return calculateVol;
    }

    @GetMapping("/")
    public String HelloSpring(){
        return "Hello Spring!";
    }

    @GetMapping("/calculate")
    public String arithemeticController(@RequestParam String operation, @RequestParam String x, @RequestParam String y) {

        String answer = mathService.arithimetic(operation, x, y);
        return answer;
    }

    @GetMapping("/tasks/{taskid}/comments/{commentid}")
    public String getindividualParams(@PathVariable String taskid,@PathVariable String commentid){
        return String.format("taskid is %s,commentid is %s",taskid,commentid);

    }
    @PostMapping("/sum")
    public String sum(@RequestParam MultiValueMap<String, String> map){
        String ans = mathService.postSum(map);
        return ans;
    }



}
