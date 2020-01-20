package com.lyx.lab.las.config;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@Configuration
@EnableSwagger2
@Slf4j
@Getter
@ToString
public class SimpleSwaggerConfig {

    @Value("${swagger.enable:true}")
    private boolean externallyConfiguredFlag;

    @Value("${swagger.basePackage:com.lyx.lab.las.controller}")
    private String basePackage;

    @PostConstruct
    public void postConstruct() {
        log.info("-- config - SimpleSwaggerConfig: {}", this);
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(externallyConfiguredFlag)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot 测试使用 Swagger2 构建RESTful API")
                .description("API 描述")
                // 作者
                // .contact(new Contact("Lyx", "http://lab.lyx.com", "lyx@lyx.com"))
                //版本
                .version("1.0")
                .build();
    }

}
