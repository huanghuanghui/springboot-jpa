package com.hhh.springbootjpa.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hhh
 * @date 2020/1/22 16:02
 * @Despriction
 */
@Getter
@Setter
public class UserPageDto {
  private Integer pageSize;
  private Integer pageIndex;
  private String userName;
  private Integer id;
  private String sortType;
}
