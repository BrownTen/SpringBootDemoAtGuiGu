package com.wyt.springboot.repository;

import com.wyt.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository<实体, 主键类型>来完成对数据的操作
public interface UserRespository extends JpaRepository<User, Integer> {

}
