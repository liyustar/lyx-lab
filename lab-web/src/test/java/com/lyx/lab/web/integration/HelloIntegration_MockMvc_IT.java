package com.lyx.lab.web.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Description HelloIntegration_WebTestClient_Test
 * @Author liyuxing
 * @Date 2019-12-14
 */
@SpringBootTest
@AutoConfigureMockMvc
public class HelloIntegration_MockMvc_IT {

    @Test
    void helloTest(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello world"));
    }

}
