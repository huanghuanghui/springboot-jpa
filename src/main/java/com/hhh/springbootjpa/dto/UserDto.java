package com.hhh.springbootjpa.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author hhh
 * @date 2020/1/22 9:41
 * @Despriction
 */
@Data
public class UserDto implements Serializable {
  private Integer id;
  @NotNull(message = "用户名不能为空")
  private String userName;
  @NotNull(message = "账户不能为空")
  private String account;
  @NotNull(message = "年龄不能为空")
  private Integer age;
}
