package com.xmz.project.service.impl.inner;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xmz.project.common.ErrorCode;
import com.xmz.project.exception.BusinessException;
import com.xmz.project.mapper.UserMapper;
import com.xmz.xmzapicommmon.model.entity.User;
import com.xmz.xmzapicommmon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author xmz
 * @date 2023-07-23
 */
@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        if(StringUtils.isAnyBlank(accessKey)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey",accessKey);
        User user= userMapper.selectOne(queryWrapper);
        return user;
    }
}
