package com.miaosha.miaosha.dao;

import com.miaosha.miaosha.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by WangPeilei
 * Time 2018/9/22 18:59
 */
@Mapper
@Repository
public interface UserDao {

    @Select("Select * from user where id = #{id}")
    User getById(@Param("id") int id);
}
