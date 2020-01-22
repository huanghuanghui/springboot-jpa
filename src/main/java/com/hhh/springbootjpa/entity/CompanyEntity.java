package com.hhh.springbootjpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author hhh
 * @date 2020/1/22 15:38
 * @Despriction
 */
@Data
@Entity(name = "sp_company")
public class CompanyEntity implements Serializable {
  @Id
  private Integer id;
  private String companyName;
}
