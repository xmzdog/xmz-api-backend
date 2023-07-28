package com.xmz.xmzapiclientsdk.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author xmz
 * @date 2023-07-14
 * 用户
 */
@Data
@ToString
public class User {

    private String username;

    /**
     * 主机号
     */
    private String host;
}
