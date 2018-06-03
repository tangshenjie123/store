package com.tangshenjie.store.mapper.user;

import com.tangshenjie.store.mapper.user.meta.StoreUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StoreUserMapper {

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @Select("select id,username,password,password_salt,email,phone,created_time,update_time from store_user where id=#{id}")
    StoreUser selectStoreUserById(Integer id);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @Select("select id,username,password,password_salt,email,phone,created_time,update_time from store_user where username=#{username}")
    StoreUser selectStoreUserByUsername(String username);

    /**
     * 插入用户操作
     * @param storeUser
     */
    @Insert("insert into store_user (" +
                "username,password,password_salt," +
                "email,phone,created_time,update_time" +
            ")values(" +
                "#{username},#{password},#{passwordSalt}," +
                "#{email},#{phone},#{createdTime},#{update_time}" +
            ")")
    void insert(StoreUser storeUser);

    /**
     * 根据邮箱查找
     * @param email
     * @return
     */
    @Select("select count(email) from store_user where email=#{email}")
    Integer selectByEmail(String email);

    /**
     * 根据电话查找
     * @param phone
     * @return
     */
    @Select("select count(phone) from store_user where phone=#{phone}")
    Integer selectByPhone(String phone);

    /**
     * 修改用户基本信息
     * @param storeUser
     */
    @Update("update store_user set " +
                "username=#{username},password=#{password},password_salt=#{passwordSalt}," +
                "email=#{email},phone=#{phone},created_time=#{createdTime}," +
                "update_time=#{updateTime} where id=#{id}")
    void updateStoreUser(StoreUser storeUser);

}
