package com.lyx.lab.las.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description HelloController
 * @Author liyuxing
 * @Date 2019-12-08
 */
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello world";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello world 2";
    }
}
