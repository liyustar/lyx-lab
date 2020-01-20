package com.lyx.lab.las.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Description HelloIntegration_WebTestClient_Test
 * @Author liyuxing
 * @Date 2019-12-14
 */
@SpringBootTest
@AutoConfigureMockMvc
public class AccountIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void addAccountTest() throws Exception {
        mvc.perform(
                post("/api/accounts")
                        .param("accCode", "ACC003")
                        .param("amt", "1000000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.accCode").value("ACC003"))
                .andExpect(jsonPath("$.data.amt").value(1_000_000.0));
    }

    @Test
    void transAccountAmtTest() throws Exception {
        mvc.perform(
                put("/api/accounts/transTo")
                        .param("fromAccCode", "ACC001")
                        .param("toAccCode", "ACC002")
                        .param("amt", "500"))
                .andExpect(status().isOk());
    }

    @Test
    void transAccountAmtTest2() throws Exception {
        mvc.perform(
                put("/api/accounts/transTo")
                        .param("fromAccCode", "ACC002")
                        .param("toAccCode", "ACC001")
                        .param("amt", "700"))
                .andExpect(status().isOk());
    }

}
