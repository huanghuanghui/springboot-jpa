package com.hhh.springbootjpa.service.impl;

import com.hhh.springbootjpa.entity.UserEntity;
import com.hhh.springbootjpa.repository.UserRepository;
import com.hhh.springbootjpa.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author hhh
 * @date 2020/1/22 9:11
 * @Despriction
 */
@Service
public class UserServiceImpl implements UserService {

  @Resource
  private UserRepository userRepository;

  @Override
  public UserEntity getById(Integer id) {
    return null;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Integer updateById(String userName, Integer id) {
    return userRepository.updateById(userName,id);
  }
}
