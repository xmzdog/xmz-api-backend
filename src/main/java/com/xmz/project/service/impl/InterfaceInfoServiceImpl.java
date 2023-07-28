package com.xmz.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xmz.project.common.ErrorCode;
import com.xmz.project.exception.BusinessException;
import com.xmz.project.mapper.InterfaceInfoMapper;
import com.xmz.project.service.InterfaceInfoService;
import com.xmz.project.service.UserService;
import com.xmz.xmzapiclientsdk.client.XmzApiClient;
import com.xmz.xmzapicommmon.model.entity.InterfaceInfo;
import com.xmz.xmzapicommmon.model.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
* @author 86188
* @description 针对表【interface_info】的数据库操作Service实现
* @createDate 2023-07-12 13:13:11
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService{

    @Resource
    private UserService userService;

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }

    @Override
    public XmzApiClient getXmzApiClient(HttpServletRequest request) {
        // 获取当前登录用户
        User loginUser = userService.getLoginUser(request);
        String accessKey = loginUser.getAccessKey();
        String secretKey = loginUser.getSecretKey();

        return new XmzApiClient(accessKey, secretKey);
    }
}




