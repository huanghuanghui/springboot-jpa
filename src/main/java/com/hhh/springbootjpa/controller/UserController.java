package com.hhh.springbootjpa.controller;

import com.hhh.springbootjpa.dto.UserDto;
import com.hhh.springbootjpa.entity.UserEntity;
import com.hhh.springbootjpa.exception.CustomException;
import com.hhh.springbootjpa.repository.UserRepository;
import com.hhh.springbootjpa.response.BaseResMessage;
import com.hhh.springbootjpa.response.PageResMessage;
import com.hhh.springbootjpa.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;

/**
 * @author hhh
 * @date 2020/1/22 9:10
 * @Despriction
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {
  @Resource
  private UserRepository userRepository;
  @Resource
  private UserService userService;

  @PostMapping("/save")
  public void save(@RequestBody @Valid UserDto userDto) {
    userRepository.save(UserEntity.newInstance(userDto));
  }

  @PostMapping("/update")
  public void update(@RequestBody @Valid UserDto userDto) {
    if (userDto.getId() == null) {
      throw new CustomException("id不能为空");
    }
    userRepository.save(UserEntity.newInstance(userDto));
  }

  @GetMapping("/getUserById/{id}")
  public UserEntity getUserById(@PathVariable("id") Integer id) {
    Optional<UserEntity> optional = userRepository.findById(id);
    return optional.isPresent() ? optional.get() : null;
  }

  @GetMapping("/getUserByName")
  public UserEntity getUserByName(String userName) {
    Optional<UserEntity> optional = userRepository.findByUserName(userName);
    return optional.isPresent() ? optional.get() : null;
  }

  @GetMapping("/findByNameCustom")
  public UserEntity findByNameCustom(String userName) {
    return userRepository.findByNameCustom(userName);
  }

  @GetMapping("/findByAgeGreaterThan")
  public BaseResMessage findByAgeGreaterThan(Integer age) {
    return BaseResMessage.success(userRepository.findByAgeGreaterThan(age));
  }

  @GetMapping("/update-name")
  public BaseResMessage updateUserName(String userName,Integer id) {
    return BaseResMessage.success(userService.updateById(userName,id));
  }

  @GetMapping("/user-info")
  public BaseResMessage userInfo(Integer id) {
    return BaseResMessage.success(userRepository.findUserInfo(id));
  }

  @PostMapping("/findUserPage")
  public PageResMessage findUserPage(@RequestBody @Valid PageRequest page) {
    //分页选项
    return PageResMessage.success(userRepository.findUserPage(page));
  }
}
