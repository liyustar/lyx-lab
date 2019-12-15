package com.lyx.lab.web.integration;

import com.lyx.lab.core.aspect.TrackTimeAspect;
import com.lyx.lab.core.aspect.WebLogAspect;
import com.lyx.lab.core.bean.ResponseEntity;
import com.lyx.lab.web.controller.request.CreateUserReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Description UserIntegrationTest
 * @Author liyuxing
 * @Date 2019-12-14
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Import({WebLogAspect.class, TrackTimeAspect.class})
public class UserIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void createUserTest_success() {
        CreateUserReq req = new CreateUserReq("apple", "APPLE");
        ResponseEntity body = restTemplate.postForObject("/api/users", req, ResponseEntity.class);
        assertThat(body).isNotNull();
    }

    @Test
    void createUserTest_fail() {
        CreateUserReq req = new CreateUserReq("", "");
        ResponseEntity body = restTemplate.postForObject("/api/users", req, ResponseEntity.class);
        assertThat(body).isNotNull();
    }

    @Test
    void getUserTest() {
        ResponseEntity body = restTemplate.getForObject("/api/users/apple", ResponseEntity.class);
        assertThat(body).isNotNull();

        LinkedHashMap map = (LinkedHashMap) body.getData();
        assertThat(map.get("name")).isEqualTo("apple");
        assertThat(map.get("password")).isEqualTo("APPLE");
    }


}
