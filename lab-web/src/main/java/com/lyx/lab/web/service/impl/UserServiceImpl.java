package com.lyx.lab.web.service.impl;

import com.lyx.lab.core.util.LabDigestUtils;
import com.lyx.lab.web.controller.request.CreateUserReq;
import com.lyx.lab.web.mapper.SysUserMapper;
import com.lyx.lab.web.model.SysUser;
import com.lyx.lab.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description UserServiceImpl
 * @Author liyuxing
 * @Date 2019-12-13
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public void createUser(CreateUserReq req) {
        SysUser user = new SysUser();
        user.setName(req.getName());
        user.setPassword(req.getPassword());
        user.setPasswordMd5(LabDigestUtils.getMD5(req.getPassword()));
        user.setPasswordSha(LabDigestUtils.getSHA1(req.getPassword()));
        userMapper.insertSelective(user);
    }

    @Override
    public SysUser getUser(String name) {
        return userMapper.selectByPrimaryKey(name);
    }
}
