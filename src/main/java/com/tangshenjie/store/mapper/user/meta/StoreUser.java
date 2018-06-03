package com.tangshenjie.store.mapper.user.meta;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class StoreUser {
    //主键
    private int id;
    //用户名
    private String username;
    //密码
    private String password;

    private String passwordSalt;
    //邮箱
    private String email;
    //电话
    private String phone;

    private long createdTime;

    private long updateTime;

}
