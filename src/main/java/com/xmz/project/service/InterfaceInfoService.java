package com.xmz.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xmz.xmzapiclientsdk.client.XmzApiClient;
import com.xmz.xmzapicommmon.model.entity.InterfaceInfo;

import javax.servlet.http.HttpServletRequest;

/**
* @author 86188
* @description 针对表【interface_info】的数据库操作Service
* @createDate 2023-07-12 13:13:11
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    /**
     * 创建SDK客户端
     *
     * @param request 当前会话
     * @return SDK客户端
     */
    XmzApiClient getXmzApiClient(HttpServletRequest request);
}
