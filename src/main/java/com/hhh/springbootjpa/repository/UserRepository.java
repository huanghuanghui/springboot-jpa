package com.hhh.springbootjpa.repository;

import com.hhh.springbootjpa.dto.UserCompanyDto;
import com.hhh.springbootjpa.entity.CompanyEntity;
import com.hhh.springbootjpa.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author hhh
 * @date 2020/1/22 9:53
 * @Despriction
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  /**
   * 根据name查询用户
   * @param userName
   * @return
   */
  Optional<UserEntity> findByUserName(String userName);

  /**
   * 自定义查询
   *JPA 支持nativeQuery，原生SQL查询
   * @param name
   * @return
   */
  @Query(value = "select * from user_entity u where u.user_name = :name order by u.id desc limit 1", nativeQuery = true)
  UserEntity findByNameCustom(String name);

  /**
   * 查询年龄大于Age的
   * @param age
   * @return
   */
  List<UserEntity> findByAgeGreaterThan(Integer age);
  /**
   * 查询年龄大于Age的
   * @param userName
   * @return
   */
  @Modifying
  @Query("update UserEntity set userName=?1 where id = ?2")
  Integer updateById(String userName ,Integer id);

  /**
   * 连表查询 不能加别名
   * @param id
   * @return
   */
  @Query(value = "select new com.hhh.springbootjpa.dto.UserCompanyDto(u.userName,p.companyName) from UserEntity u,sp_company p where u.companyId = p.id and u.id = :id")
  UserCompanyDto findUserInfo(Integer id);

  /**
   * 分页查询
   * @param pageable
   * @return
   */
  @Query(value = "select id,companyName from sp_company",countQuery = "select id,companyName from sp_company")
  Page<CompanyEntity> findUserPage(Pageable pageable);
}
