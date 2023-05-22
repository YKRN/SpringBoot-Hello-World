package com.example.helloworld;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;




@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CheckHTTPResponse {
    public  CheckHTTPResponse(){


    }

    @LocalServerPort
    private int port;


    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void shouldPassIfStringMatches(){

        Assertions.assertEquals("Hello World",testRestTemplate.getForObject("http://localhost:"+port+"/",String.class));
        Assertions.assertEquals("Good Bye",testRestTemplate.getForObject("http://localhost:"+port+"/goodbye",String.class));



    }

}
