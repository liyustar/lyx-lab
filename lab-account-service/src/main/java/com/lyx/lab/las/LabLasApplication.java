package com.lyx.lab.las;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lyx.lab.las.mapper")
public class LabLasApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabLasApplication.class, args);
    }

}
