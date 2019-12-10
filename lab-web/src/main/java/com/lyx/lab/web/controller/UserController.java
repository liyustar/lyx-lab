package com.lyx.lab.web.controller;

import com.lyx.lab.web.mapper.SysUserMapper;
import com.lyx.lab.web.model.SysUser;
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
    private SysUserMapper sysUserMapper;

    @PostMapping()
    public int createUser(@RequestBody SysUser user) {
        log.info("user <{}>", user);
        return sysUserMapper.insertSelective(user);
    }

    @GetMapping("/{name}")
    public SysUser getUser(@PathVariable(value = "name") String name) {
        SysUser user = sysUserMapper.selectByPrimaryKey(name);
        log.info("user <{}>", user);
        return user;
    }

}
