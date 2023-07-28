package com.xmz.xmzapiinterface;


import com.xmz.xmzapiclientsdk.client.XmzApiClient;
import com.xmz.xmzapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class XmzapiInterfaceApplicationTests {

    @Resource
    private XmzApiClient xmzApiClient;

    @Test
    void contextLoads() {
        String xmz = xmzApiClient.getNameByGet("xmz");
        User user = new User();
        user.setUsername("gsy");
        String userNameByPost = xmzApiClient.getUserNameByPost(user);
        System.out.println(xmz);
        System.out.println(userNameByPost);
    }

}
