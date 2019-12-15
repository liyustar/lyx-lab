package com.lyx.lab.web.controller;

import com.lyx.lab.core.aspect.TrackTime;
import com.lyx.lab.core.aspect.WebLog;
import com.lyx.lab.core.bean.ResponseEntity;
import com.lyx.lab.web.controller.request.CreateUserReq;
import com.lyx.lab.web.model.SysUser;
import com.lyx.lab.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping()
    @WebLog
    public ResponseEntity createUser(@RequestBody CreateUserReq req) {
        service.createUser(req);
        return ResponseEntity.success();
    }

    /**
     * 查询用户
     * @param name
     * @return
     */
    @GetMapping("/{name}")
    @WebLog
    @TrackTime
    public ResponseEntity<SysUser> getUser(@PathVariable(value = "name") String name) {
        SysUser user = service.getUser(name);
        return ResponseEntity.success(user);
    }

}
