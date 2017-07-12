package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

/**
 * Created by saseri on 7/11/2017.
 */

@Service
public class MathService {


        public String arithimetic(String operation,String x,String y) {


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


    public String postSum(MultiValueMap<String, String> map){


        java.util.List list = map.get("n");

        int size = list.size();
        int ans=0;

        for(int i=0; i<size; i++) {
            ans = ans+ Integer.parseInt(String.valueOf(list.get(i)));
        }

        return String.valueOf(ans);
    }
    public String volume (String length,String breath,String height){
        int ans = Integer.parseInt(length)*Integer.parseInt(breath)*Integer.parseInt(height);

        return String.format("The volume of a %sx%sx%s rectangle is %s", length, breath, height, ans);
    }
}
