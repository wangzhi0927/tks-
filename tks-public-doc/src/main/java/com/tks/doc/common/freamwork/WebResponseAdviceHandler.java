package com.tks.doc.common.freamwork;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tks.resource.freamwork.BusinessResult;
import com.tks.resource.freamwork.ResponseAdviceHandler;

import feign.FeignException;

/**
 * @Author liuxiaoxin
 * @Descrpition
 * @Date 2018/5/13
 * @Modified By:
 */
@RestControllerAdvice
public class WebResponseAdviceHandler extends ResponseAdviceHandler {

    @ExceptionHandler(FeignException.class)
    @ResponseBody
    public BusinessResult processValidationFeignError(FeignException ex) {
        BusinessResult response = BusinessResult.failed(BusinessResult.UNAUTHORIZED_CODE, "");
        response.setData(ex.getMessage());
        return response;
    }
}
