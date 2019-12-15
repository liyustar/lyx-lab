package com.lyx.lab.core.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Description ResponseEntity
 * @Author liyuxing
 * @Date 2019-12-08
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponseEntity <T> {

    private T data;

    public static ResponseEntity success() {
        return new ResponseEntity(null);
    }

    public static <T> ResponseEntity success(T data) {
        return new ResponseEntity(data);
    }

}
