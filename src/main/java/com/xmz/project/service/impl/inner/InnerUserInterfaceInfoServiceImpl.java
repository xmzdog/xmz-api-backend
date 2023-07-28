package com.xmz.project.service.impl.inner;

import com.xmz.project.service.UserInterfaceInfoService;
import com.xmz.xmzapicommmon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author xmz
 * @date 2023-07-23
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;
    @Override
    public boolean invokeCount(long interfaceInfoid, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoid,userId);
    }
}
