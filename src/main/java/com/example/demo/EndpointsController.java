package com.example.demo;

/**
 * Created by saseri on 7/6/2017.
 */
import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController
@RequestMapping("/math")
public class EndpointsController {

@Autowired
private MathService mathService;

    @GetMapping("/")
    public String HelloSpring(){
        return "Hello Spring!";
    }

    @GetMapping("/calculate")
    public String arithemeticController(@RequestParam String operation, @RequestParam String x, @RequestParam String y) {

        String answer = mathService.arithimetic(operation, x, y);
        return answer;
    }

    @PostMapping("/sum")
    public String sum(@RequestParam MultiValueMap<String, String> map){
        String ans = mathService.postSum(map);
        return ans;
    }

}
