package com.lyx.lab.web.controller;

import com.lyx.lab.core.aspect.TrackTime;
import com.lyx.lab.core.aspect.WebLog;
import com.lyx.lab.core.bean.ResponseObj;
import com.lyx.lab.web.controller.request.CreateUserReq;
import com.lyx.lab.web.model.SysUser;
import com.lyx.lab.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description UserController
 * @Author liyuxing
 * @Date 2019-12-08
 */
@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService service;

    /**
     * 创建用户
     * @param req
     * @return
     */
    @PostMapping
    @WebLog
    public ResponseObj createUser(@RequestBody @Valid CreateUserReq req) {
        service.createUser(req);
        return ResponseObj.success();
    }

    /**
     * 查询用户
     * @param name
     * @return
     */
    @GetMapping("/{name}")
    @WebLog
    @TrackTime
    public ResponseObj<SysUser> getUser(@PathVariable(value = "name") String name) {
        SysUser user = service.getUser(name);
        return ResponseObj.success(user);
    }

}
