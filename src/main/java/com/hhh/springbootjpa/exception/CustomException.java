package com.hhh.springbootjpa.exception;

/**
 * @author hhh
 * @date 2020/1/22 10:43
 * @Despriction
 */
public class CustomException extends RuntimeException{

  public CustomException(String message) {
    super(message);
  }
}
