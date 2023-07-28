package com.xmz.xmzapiclientsdk.client;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.xmz.xmzapiclientsdk.model.User;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static com.xmz.xmzapiclientsdk.Utils.SignUtils.getSign;

/**
 * @author xmz
 * @date 2023-07-14
 * 调用第三方接口的客户端
 */
public class XmzApiClient {

    private static  String GATEWAY_HOST = "http://localhost:8090";

    private String accessKey;

    private String secretKey;

    public XmzApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name){
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name",name);

        String result= HttpUtil.get(GATEWAY_HOST+"/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public void setGatewayHost(String gatewayHost) {
        GATEWAY_HOST = gatewayHost;
    }


    public String getNameByPost(String name){
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name",name);

        String result= HttpUtil.get(GATEWAY_HOST+"/api/name/", paramMap);
        System.out.println(result);
        return result;

    }



//    private Map<String,String> getHeaderMap(String body){
//        Map<String,String> hashMap = new HashMap<>();
//        hashMap.put("accessKey",accessKey);
//        //一定不能直接发送
////        hashMap.put("secreKey",secreKey);
//        hashMap.put("nonce", RandomUtil.randomNumbers(4));
//        hashMap.put("body",body);
//        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
//        hashMap.put("sign",getSign(body,secretKey));
//        return hashMap;
//    }

    private Map<String, String> getHeaderMap(String body, String method) throws UnsupportedEncodingException {
        HashMap<String, String> map = new HashMap<>();
        map.put("accessKey", accessKey);
        map.put("nonce", RandomUtil.randomNumbers(10));
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("sign", getSign(body, secretKey));
        body = URLUtil.encode(body, CharsetUtil.CHARSET_UTF_8);
        map.put("body", body);
        map.put("method", method);
        return map;
    }

    public String invokeInterface(String params, String url,String method) throws UnsupportedEncodingException {
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + url)
                .header("Accept-Charset", CharsetUtil.UTF_8)
                .addHeaders(getHeaderMap(params,method))
                .body(params)
                .execute();
        return JSONUtil.formatJsonStr(httpResponse.body());
    }


//    public String getUserNameByPost(User user) {
//        String json = JSONUtil.toJsonStr(user);
//        HttpResponse execute = HttpRequest.post(GATEWAY_HOST+"/api/name/user")
//                .addHeaders(getHeaderMap(json))
//                .body(json)
//                .execute();
//        System.out.println(execute.getStatus());
//        System.out.println(execute.body());
//        return execute.body();
//    }
}
