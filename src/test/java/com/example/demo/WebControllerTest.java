package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testWebController(){
        assertEquals(restTemplate.getForEntity("/api/tree/3",String.class).getBody(),"3");
    }

}
