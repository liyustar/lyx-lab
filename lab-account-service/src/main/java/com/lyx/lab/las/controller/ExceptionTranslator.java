package com.lyx.lab.las.controller;

import com.lyx.lab.core.bean.ResponseObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description ExceptionHandler
 * @Author liyuxing
 * @Date 2019-12-15
 */
@ControllerAdvice
@Slf4j
public class ExceptionTranslator {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseObj processMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        log.error("参数校验失败:" + e.getMessage(), e);
        return ResponseObj.fail("参数校验失败:" + fieldErrorsToString(fieldErrors));
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseObj processException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseObj.fail(e.getMessage());
    }

    private String fieldErrorsToString(List<FieldError> fieldErrors) {
        StringBuilder stringBuilder = fieldErrors.stream()
                .map(fe -> String.format("%s-%s: %s;", fe.getObjectName(), fe.getField(), fe.getCode()))
                .reduce(new StringBuilder(), (sb, str) -> sb.append(str), (sb, sb2) -> sb);
        return stringBuilder.toString();
    }
}
