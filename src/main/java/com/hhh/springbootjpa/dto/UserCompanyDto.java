package com.hhh.springbootjpa.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hhh
 * @date 2020/1/22 14:58
 * @Despriction
 */
@Data
public class UserCompanyDto implements Serializable {
  private String userName;
  private String companyName;
  public UserCompanyDto(String userName,String companyName){
    this.userName=userName;
    this.companyName=companyName;
  }
}
