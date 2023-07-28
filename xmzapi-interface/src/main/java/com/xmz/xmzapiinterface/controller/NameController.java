package com.xmz.xmzapiinterface.controller;


import com.xmz.xmzapiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xmz
 * @date 2023-07-14
 * 名称 API
 */
@RestController
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name,HttpServletRequest request){
        System.out.println(request.getHeader("xmz"));
        return "GET 你的名字是"+name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name){
        return "POST 你的名字是"+name;
    }

    @PostMapping("/name/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {
//        String accessKey = request.getHeader("accessKey");
//        String timestamp = request.getHeader("timestamp");
//        String nonce = request.getHeader("nonce");
//        String sign = request.getHeader("sign");
//        String body = request.getHeader("body");
//        //todo 实际情况应该是去数据库中查看是否分配给用户
//        if(!accessKey.equals("xmz")){
//            throw new RuntimeException("无权限");
//        }
//        if(Long.parseLong(nonce) > 10000){
//            throw new RuntimeException("无权限");
//        }
//        //todo 时间和当前时间不能超过5分钟
////        if(timestamp){}
//        //todo 实际情况是从数据库中查出 secretKey
//        String serversign = SignUtils.getSign(body, "abcdefgh");
//        if(!sign.equals(serversign)){
//            throw new RuntimeException("无权限");
//        }
        String result =  "POST 用户的名字是"+user.getUsername();
        //调用成功后
        return result;
    }
}
