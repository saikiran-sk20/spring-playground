package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Random;

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

/*@Test
    public void test() throws Exception{
        //RequestBuilder request= MockMvcRequestBuilders.get("/hello");
        this.mvc.perform(get("/query/test?type=car&id=noid"))
                .andExpect(status().isOk())
                .andExpect(content().string("type=car,id=noid");*//*
    }*/
@Test
public void testPostCircleArea()throws Exception {
    MockHttpServletRequestBuilder request = post("/math/area")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("type", "circle")
            .param("radius", "3");
    this.mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string("Area of circle with radius of 3 is 28.274334"));
}
    @Test
            public void testPostRectangleArea()throws Exception{
    MockHttpServletRequestBuilder request = post("/math/area")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("type","rectangle")
            .param("length","3")
            .param("width","3");
    this.mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string("Area of 3*3 rectangle is 9"));
}
    @Test
    public void testPostInvalidArea()throws Exception{
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type","rectangle")
                .param("radius","3");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Area cannot be calculated as the entries are Invalid"));
    }
/*@Test
public void testCreateComment()throws Exception {
    String content = String.valueOf(new Random().nextInt());
    MockHttpServletRequestBuilder request = post("/comments")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("content", content)
            .param("author", "dwayne");*//*
}*/
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
