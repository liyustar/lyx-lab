package com.lyx.lab.web.mapper;

import com.lyx.lab.web.model.SysUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Description SysUserMapperTest
 * @Author liyuxing
 * @Date 2019-12-14
 */
@MybatisTest(properties = {
        "mybatis.type-aliases-package=org.mybatis.spring.boot.test.autoconfigure",
        "logging.level.org.springframework.jdbc=debug",
        "spring.datasource.schema=classpath:db/schema-mysql.sql" })
class SysUserMapperTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @BeforeEach
    public void setup() {
        SysUser user = new SysUser();
        user.setName("apple");
        user.setPassword("APPLE");

        sysUserMapper.insertSelective(user);
    }

    @Test
    public void findByName() {
        SysUser user = sysUserMapper.selectByPrimaryKey("apple");
        assertThat(user.getName()).isEqualTo("apple");
        assertThat(user.getPassword()).isEqualTo("APPLE");
    }

    @Test
    public void findByName_notFind() {
        SysUser user = sysUserMapper.selectByPrimaryKey("banana");
        assertThat(user).isNull();
    }

}