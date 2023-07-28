package com.xmz.xmzapiclientsdk;

import com.xmz.xmzapiclientsdk.client.XmzApiClient;
import com.xmz.xmzapiclientsdk.model.User;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xmz
 * @date 2023-07-14
 */
@Configuration
@ConfigurationProperties("xmzapi.client")
@Data
@ComponentScan
public class XmzApiClientConfig {
    private String accessKey;

    private String secreKey;

    //生成客户端的方法
    @Bean
    public XmzApiClient xmzApiClient(){
       return new XmzApiClient(accessKey,secreKey);

    }
}
