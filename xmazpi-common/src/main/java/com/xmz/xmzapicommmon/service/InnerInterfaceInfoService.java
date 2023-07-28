package com.xmz.xmzapicommmon.service;

import com.xmz.xmzapicommmon.model.entity.InterfaceInfo;

/**
* @author 86188
* @description 针对表【interface_info】的数据库操作Service
* @createDate 2023-07-12 13:13:11
*/
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询模拟接口是否存在（请求路径、请求方法，布尔）
     * @param path
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String path,String method);

}
