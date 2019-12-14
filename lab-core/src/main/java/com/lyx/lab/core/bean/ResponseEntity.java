package com.lyx.lab.core.bean;

/**
 * @Description ResponseEntity
 * @Author liyuxing
 * @Date 2019-12-08
 */
public class ResponseEntity <T> {

    public static ResponseEntity success() {
        return new ResponseEntity();
    }

    public static <T> ResponseEntity success(T data) {
        return new ResponseEntity<T>();
    }
}
