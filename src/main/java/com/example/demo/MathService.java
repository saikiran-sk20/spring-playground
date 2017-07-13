package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * Created by saseri on 7/11/2017.
 */

@Service
public class MathService {


    public String arithimetic(String operation, String x, String y) {


        if (operation.equalsIgnoreCase("sum")) {
            int sum = Integer.parseInt(x) + Integer.parseInt(y);
            return String.format("%s + %s = %d", x, y, sum);
        } else if (operation.equalsIgnoreCase("sub")) {
            int sub = Integer.parseInt(x) - Integer.parseInt(y);
            return String.format("%s - %s = %d", x, y, sub);
        } else if (operation.equalsIgnoreCase("multiply")) {
            int multiply = Integer.parseInt(x) * Integer.parseInt(y);
            return String.format("%s * %s = %d", x, y, multiply);
        } else if (operation.equalsIgnoreCase("divide")) {
            int divide = Integer.parseInt(x) / Integer.parseInt(y);
            return String.format("%s / %s = %d", x, y, divide);
        }

        return "Operation not found";
    }


    public String postSum(MultiValueMap<String, String> map) {


        java.util.List list = map.get("n");

        int size = list.size();
        int ans = 0;

        for (int i = 0; i < size; i++) {
            ans = ans + Integer.parseInt(String.valueOf(list.get(i)));
        }

        return String.valueOf(ans);
    }

    public String volume(String length, String breath, String height) {
        int ans = Integer.parseInt(length) * Integer.parseInt(breath) * Integer.parseInt(height);

        return String.format("The volume of a %sx%sx%s rectangle is %s", length, breath, height, ans);
    }

    public String area(Map<String, String> form) throws Exception {

        String type = form.get("type");
        if (form.get("type").equalsIgnoreCase("circle") & (form.containsKey("length") || form.containsKey("width"))) {
            return String.format("Area cannot be calculated as the entries are Invalid");
        } else if (type.equalsIgnoreCase("rectangle") & form.containsKey("radius")) {
            return String.format("Area cannot be calculated as the entries are Invalid");
        } else if (type.equalsIgnoreCase("circle")) {
            String r = form.get("radius");
            Double circleArea = Math.PI * Integer.parseInt(r) * Integer.parseInt(r);
            return String.format("Area of circle with radius of %s is %f", String.valueOf(form.get("radius")), circleArea);
        } else if (type.equalsIgnoreCase("rectangle")) {
            String l = form.get("length");
            String w = form.get("width");
            int rectangleArea = Integer.parseInt(l) * Integer.parseInt(w);
            return String.format("Area of %s*%s rectangle is %d", String.valueOf(l), String.valueOf(w), rectangleArea);
        }


        return String.format("check form data or business logic ");
    }

}
