package com.xmz.xmzapicommmon.service;



/**
* @author 86188
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-07-19 13:06:07
*/
public interface InnerUserInterfaceInfoService  {

    /**
     * 调用接口统计
     * @param interfaceInfoid
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoid,long userId);
}
