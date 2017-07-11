package com.example.demo;
import org.junit.Assert;
/*
import org.junit.Before;
*/
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/*import java.lang.Math;
import java.util.**/

/**
 * Created by saseri on 7/11/2017.
 */
public class MathServiceTest {

    /*  *//*  public Math math;
        @Before
        public void add("sum",) throws Exception {
            math = new Math(2, 3);
        }*/
        @Test
        public void testAdd() {
            MathService mathService= new MathService();
            String result = mathService.arithimetic("sum","2","3");
            int answer = java.lang.Math.addExact(2,3);

            Assert.assertEquals(String.format("2 + 3 = %d", answer), result);
        }

    @Test
    public void testSub() {
        MathService mathService= new MathService();
        String result = mathService.arithimetic("sub","3","2");
        int answer = java.lang.Math.subtractExact(3,2);

        Assert.assertEquals(String.format("3 - 2 = %d", answer), result);
    }

    @Test
    public void testMul() {
        MathService mathService= new MathService();
        String result = mathService.arithimetic("multiply","2","3");
        int answer = java.lang.Math.multiplyExact(2,3);

        Assert.assertEquals(String.format("2 * 3 = %d", answer), result);
    }

    @Test
    public void testDiv() {
        MathService mathService= new MathService();
        String result = mathService.arithimetic("divide","6","3");
        int answer = java.lang.Math.floorDiv(6,3);

        Assert.assertEquals(String.format("6 / 3 = %d", answer), result);

        }

    @Test
    public void postSumTest() {
        MathService mathService= new MathService();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String,String>();


        map.add("n", "6");
        map.add("n", "6");
        map.add("n", "6");
        String result = mathService.postSum(map);


        Assert.assertEquals(String.format("%s",18), result);

    }
}
