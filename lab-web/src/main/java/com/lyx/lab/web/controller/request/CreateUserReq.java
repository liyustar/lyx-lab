package com.lyx.lab.web.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description CreateUserReq
 * @Author liyuxing
 * @Date 2019-12-13
 */
@Getter
@Setter
@AllArgsConstructor
public class CreateUserReq {
    private String name;
    private String password;
}
