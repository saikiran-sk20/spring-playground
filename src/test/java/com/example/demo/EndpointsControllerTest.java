package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
/**
 * Created by saseri on 7/9/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(EndpointsController.class)
public class EndpointsControllerTest {

    @Autowired
    public MockMvc mvc;
/*

@Test
    public void test() throws Exception{
        //RequestBuilder request= MockMvcRequestBuilders.get("/hello");
        this.mvc.perform(get("/query/test?type=car&id=noid"))
                .andExpect(status().isOk())
                .andExpect(content().string("type=car,id=noid");
    }
*/



@Test
    public void testMathServiceGet() throws Exception{
    this .mvc.perform(get("/math/calculate?operation=sum&x=2&y=3"))
            .andExpect(status().isOk())
            .andExpect(content().string("2 + 3 = 5"));
    }
@Test
    public void testMathServicePost() throws Exception{
    this .mvc.perform(post("/math/sum?n=2&n=3&n=4"))
            .andExpect(status().isOk())
            .andExpect(content().string("9"));
    }
}
