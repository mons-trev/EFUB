package com.example.efub.seminar07.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void returnHello() throws Exception {
        String hello= "hello";
        mvc.perform(get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }


    @Test
    public void exampleGET() throws Exception {
        MultiValueMap<String, String> info = new LinkedMultiValueMap<>();

        info.add("query", "efub");
        info.add("language", "kr");

        mvc.perform(get("/search")
                .params(info)).andExpect(status().isOk).andExpect(content().string("검색어는 efub이고 언어는 kr입니다.  ")).andDo(MockMvcResultHandlers.print());
    }
}