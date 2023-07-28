package com.xmz.xmzapicommmon.service;



import com.xmz.xmzapicommmon.model.entity.User;


/**
 * 用户服务
 *
 * @author xmz
 */
public interface InnerUserService  {

    /**
     * 数据库中查看是否分配给用户密钥（accessKey，布尔）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);

}
