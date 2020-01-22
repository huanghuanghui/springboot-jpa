package com.hhh.springbootjpa.exception;

import com.hhh.springbootjpa.response.BaseResMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author hhh
 * @date 2020/1/22 9:57
 * @Despriction
 */
@ControllerAdvice
@Component
@Log4j2
@ResponseBody
public class ExceptionHandle {

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public BaseResMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    log.error("MethodArgumentNotValidException:",e);
    BaseResMessage res = new BaseResMessage();
    List<ObjectError> ex =e.getBindingResult().getAllErrors();
    res.setCode(500);
    ObjectError error =  ex.get(0);
    res.setMessage(error.getDefaultMessage());
    return res;
  }

  @ExceptionHandler(value = CustomException.class)
  public BaseResMessage handleCustomException(CustomException e) {
    log.error("CustomException:",e);
    BaseResMessage res = new BaseResMessage();
    res.setMessage(e.getMessage());
    res.setCode(500);
    return res;
  }
}
