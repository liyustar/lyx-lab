package com.lyx.lab.web.service;

import com.lyx.lab.web.controller.request.CreateUserReq;
import com.lyx.lab.web.model.SysUser;

/**
 * @Description UserService
 * @Author liyuxing
 * @Date 2019-12-13
 */
public interface UserService {
    void createUser(CreateUserReq req);

    SysUser getUser(String name);
}
