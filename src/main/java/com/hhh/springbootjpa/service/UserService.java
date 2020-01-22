package com.hhh.springbootjpa.service;

import com.hhh.springbootjpa.entity.UserEntity;

/**
 * @author hhh
 * @date 2020/1/22 9:11
 * @Despriction
 */
public interface UserService {
  /**
   * @param id
   * @return
   */
  UserEntity getById(Integer id);
  /**
   * @param id
   * @return
   */
  Integer updateById(String userName,Integer id);
}
