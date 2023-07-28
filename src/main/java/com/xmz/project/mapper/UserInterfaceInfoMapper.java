package com.xmz.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xmz.xmzapicommmon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author 86188
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2023-07-19 13:06:07
* @Entity com.xmz.project.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    //select interfaceInfoId,sum(totalNum) as total from user_interface_info group by interfaceInfoId order by totalNum desc limit 3
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




