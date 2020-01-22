package com.hhh.springbootjpa.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hhh
 * @date 2020/1/22 10:00
 * @Despriction
 */
@Data
public class BaseResMessage<T> implements Serializable {
  private Integer code;
  private String message;
  private T date;

  public static BaseResMessage success(Object date){
    BaseResMessage res = new BaseResMessage();
    res.setCode(200);
    res.setMessage("情求成功");
    res.setDate(date);
    return res;
  }
}
