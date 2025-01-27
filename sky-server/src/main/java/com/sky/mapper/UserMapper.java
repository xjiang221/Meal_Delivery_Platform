package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {

    /**
     * 根据openId查询用户
     *
     * @param openId
     * @return
     */
    @Select("select * from user where openid = #{openId}")
    User seleteByOpenId(String openId);

    /**
     * 新增用户
     *
     * @param user
     */
    void insert(User user);

    /**
     * 根据用户id查询用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getById(Long id);

    /**
     * 计算总用户和新增用户
     *
     * @param totalMap
     * @return
     */
    Integer countByMap(Map totalMap);
}
