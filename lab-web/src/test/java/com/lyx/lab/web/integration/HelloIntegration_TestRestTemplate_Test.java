package com.lyx.lab.web.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Description HelloIntegration_TestRestTemplate_Test
 * @Author liyuxing
 * @Date 2019-12-14
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloIntegration_TestRestTemplate_Test {

    @Test
    void helloTest(@Autowired TestRestTemplate restTemplate) {
        String body = restTemplate.getForObject("/api/hello", String.class);
        assertThat(body).isEqualTo("hello world");
    }

}
