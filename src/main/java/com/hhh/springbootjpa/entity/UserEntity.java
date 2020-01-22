package com.hhh.springbootjpa.entity;

import com.hhh.springbootjpa.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author hhh
 * @date 2020/1/22 9:11
 * @Despriction
 */
@Entity
@Data
@NoArgsConstructor
public class UserEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(unique = true)
  private String account;
  private String userName;
  private Integer age;
  private Integer companyId;

  public static UserEntity newInstance(UserDto userDto) {
    UserEntity user = new UserEntity();
    user.setId(userDto.getId());
    user.setAccount(userDto.getAccount());
    user.setUserName(userDto.getUserName());
    user.setAge(userDto.getAge());
    return user;
  }
}
