package com.lyx.lab.web.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.lyx.lab.web.model.SysUser;
import com.lyx.lab.web.model.SysUserExample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

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
@Import(PageInterceptor.class)
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

    @Test
    public void pageHelperTest() {
        for (int i = 0; i < 10; i++) {
            SysUser user = new SysUser();
            user.setName("banana" + i);
            user.setPassword("BANANA");
            sysUserMapper.insertSelective(user);
        }

        Page<SysUser> sysUsers = PageHelper.startPage(1, 3)
                .doSelectPage(() -> sysUserMapper.selectByExample(new SysUserExample()));
        assertThat(sysUsers.getTotal()).isEqualTo(11);
        assertThat(sysUsers.getPages()).isEqualTo(4);
        assertThat(sysUsers.getPageNum()).isEqualTo(1);
        assertThat(sysUsers.getPageSize()).isEqualTo(3);
        assertThat(sysUsers.getResult().size()).isEqualTo(3);
    }

}