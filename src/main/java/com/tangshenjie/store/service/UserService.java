package com.tangshenjie.store.service;

import com.tangshenjie.store.mapper.user.meta.StoreUser;

public interface UserService {

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    StoreUser getStoreUserById(Integer id);

    /**
     * 用户注册
     *
     * @param storeUser
     */
    void register(StoreUser storeUser);

    /**
     * 检查邮箱
     *
     * @param email
     * @return
     */
    boolean checkEmail(String email);

    /**
     * 检查电话
     *
     * @param phone
     * @return
     */
    boolean checkPhone(String phone);

    /**
     * 检查用户名
     *
     * @param username
     * @return
     */
    boolean checkUsername(String username);

    /**
     * 用户登录
     *
     * @param username
     * @param password
     */
    StoreUser login(String username, String password);

    /**
     * 更改密码
     *
     * @param id
     * @param oldPwd
     * @param newPwd
     */
    void changePassword(Integer id, String oldPwd, String newPwd);

    /**
     * 修改用户信息
     *
     * @param id
     * @param username
     * @param email
     * @param phone
     */
    void updateUser(Integer id, String username, String email, String phone);


}
