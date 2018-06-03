package com.tangshenjie.store.service;

import com.tangshenjie.store.mapper.user.StoreUserMapper;
import com.tangshenjie.store.mapper.user.meta.StoreUser;
import com.tangshenjie.store.service.ex.PasswordNotMatchException;
import com.tangshenjie.store.service.ex.UserNotFoundException;
import com.tangshenjie.store.service.ex.UsernameAlreadyExsitException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
public class UserServiceImpl extends SecurityService implements UserService {
    @Resource
    private StoreUserMapper storeUserMapper;

    @Override
    public StoreUser getStoreUserById(Integer id) {
        //返回storeUser对象
        return storeUserMapper.selectStoreUserById(id);
    }

    @Override
    public void register(StoreUser storeUser) {
        //检查用户名是否存在，不存在实现插入操作，存在则抛异常
        if (storeUserMapper.selectStoreUserByUsername(storeUser.getUsername()) == null) {
            String newPwd = DigestUtils.md5Hex(storeUser.getPassword() + storeUser.getPasswordSalt());
            storeUserMapper.insert(storeUser);
        } else {
            throw new UsernameAlreadyExsitException("用户名已存在！！！");
        }
    }

    @Override
    public boolean checkEmail(String email) {
        /*
        邮箱存在返回true，反之为false
         */
        return storeUserMapper.selectByEmail(email) > 0;
    }

    @Override
    public boolean checkPhone(String phone) {
        /*
        电话存在返回true，反之为false
         */
        return storeUserMapper.selectByPhone(phone) > 0;
    }

    @Override
    public boolean checkUsername(String username) {
        StoreUser storeUser = storeUserMapper.selectStoreUserByUsername(username);
        if (storeUser == null) {
            //不存在返回false
            return false;
        } else {
            //存在为true
            return true;
        }
    }

    @Override
    public StoreUser login(String username, String password) {
        //调用持久层方法查找用户
        StoreUser storeUser = storeUserMapper.selectStoreUserByUsername(username);
        if (storeUser == null) {
            //如果为空说明该用户不存在
            throw new UserNotFoundException("该用户不存在！！！");
        } else {
            String newPwd = DigestUtils.md5Hex(password + storeUser.getPasswordSalt());
            //如果不为空，从user中取出password与页面password做比较
            if (storeUser.getPassword().equals(newPwd)) {
                //密码正确返回用户对象，反之抛出异常
                return storeUser;
            } else {
                throw new PasswordNotMatchException("密码错误！！！");
            }
        }
    }

    @Override
    public void changePassword(Integer id, String oldPwd, String newPwd) {
        //调用持久层方法，找到user对象
        StoreUser storeUser = storeUserMapper.selectStoreUserById(id);
        //判断对象是否为空
        if (storeUser != null) {
            //获取密码并且和oldPwd进行比对
            String newOpwd = DigestUtils.md5Hex(oldPwd + storeUser.getPasswordSalt());
            if (storeUser.getPassword().equals(newOpwd)) {
                StoreUser su = new StoreUser();
                su.setId(id);
                su.setPassword(DigestUtils.md5Hex(newPwd + storeUser.getPasswordSalt()));
                //调用持久层方法修改密码
                storeUserMapper.updateStoreUser(su);
            }
        } else {
            //反之抛出异常
            throw new PasswordNotMatchException("密码错误！！！");
        }
    }

    @Override
    public void updateUser(Integer id, String username, String email, String phone) {
        StoreUser storeUser = new StoreUser();
        //判断用户名是否存在
        StoreUser su1 = storeUserMapper.selectStoreUserByUsername(username);
        if (su1 == null) {
            storeUser.setUsername(username);
        } else {
            //用户名存在
            StoreUser su2 = storeUserMapper.selectStoreUserById(id);
            if (su2 != null) {
                if (su2.getUsername().equals(username)) {
                    //不修改用户名
                } else {
                    throw new UsernameAlreadyExsitException("用户名已存在！！！");
                }
            }
        }
        storeUser.setId(id);
        storeUser.setUsername(username);
        storeUser.setEmail(email);
        storeUser.setPhone(phone);
        storeUserMapper.updateStoreUser(storeUser);
    }

}
