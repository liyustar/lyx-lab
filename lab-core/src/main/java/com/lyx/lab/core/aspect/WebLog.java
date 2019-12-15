package com.lyx.lab.core.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description WebLog
 * @Author liyuxing
 * @Date 2019-12-15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface WebLog {
    /**
     * 日志描述信息
     * @return
     */
    String description() default "";
}
