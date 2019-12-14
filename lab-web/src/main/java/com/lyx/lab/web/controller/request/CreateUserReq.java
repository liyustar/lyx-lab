package com.lyx.lab.web.controller.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description CreateUserReq
 * @Author liyuxing
 * @Date 2019-12-13
 */
@Getter
@Setter
public class CreateUserReq {
    private String name;
    private String password;
}
