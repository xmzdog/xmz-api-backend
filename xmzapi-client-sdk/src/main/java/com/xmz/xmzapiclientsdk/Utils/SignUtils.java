package com.xmz.xmzapiclientsdk.Utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @author xmz
 * @date 2023-07-14
 * 签名工具
 */
public class SignUtils {

    /**
     * 生成签名
     * @param body
     * @param secreKey
     * @return
     */
    public static String getSign(String body, String secreKey){
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secreKey;
        String digestHex = md5.digestHex(content);
        return digestHex;
    }
}
