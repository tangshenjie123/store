package com.tangshenjie.store.mapper.user.meta;

import lombok.Data;

@Data
public class ResponseResult<T> {

    //状态
    private Integer state;

    //信息
    private String message;

    //数据
    private T data;
}
