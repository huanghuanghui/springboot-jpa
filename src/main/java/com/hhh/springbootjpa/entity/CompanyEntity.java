package com.hhh.springbootjpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author hhh
 * @date 2020/1/22 15:38
 * @Despriction
 */
@Getter
@Setter
@Entity(name = "sp_company")
public class CompanyEntity implements Serializable {
  @Id
  private Integer id;
  private String companyName;

  public CompanyEntity() {
  }

  public CompanyEntity(Integer id,String companyName) {
    this.id=id;
    this.companyName=companyName;
  }
}
