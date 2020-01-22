package com.hhh.springbootjpa.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

/**
 * @author hhh
 * @date 2020/1/22 16:02
 * @Despriction
 */
@Getter
@Setter
public class UserPageDto extends PageRequest {
  public UserPageDto(int page, int size,String sortType) {
    super(page, size, Sort.by(!StringUtils.isEmpty(sortType)&&"asc".equalsIgnoreCase(sortType)?Sort.Direction.ASC:Sort.Direction.DESC));
  }

  public UserPageDto(int page, int size, String userName, Integer id, String sortType) {
    super(page, size, Sort.by(!StringUtils.isEmpty(sortType)&&"asc".equalsIgnoreCase(sortType)?Sort.Direction.ASC:Sort.Direction.DESC));
    this.userName = userName;
    this.id = id;
    this.sortType = sortType;
  }

  private String userName;
  private Integer id;
  private String sortType;
}
