package org.jeecg.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 设置静态参数初始化
 * @author: jeecg-boot
 */
@Component
@Data
public class StaticConfig2 {

    @Value("${jeecg.oss.sp_id}")
    private String sp_id;

    @Value("${jeecg.oss.password}")
    private String password;

    @Value("${jeecg.oss.url}")
    private String url;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

//    /**
//     * 签名密钥串
//     */
//    @Value(value = "${jeecg.signatureSecret}")
//    private String signatureSecret;


    /*@Bean
    public void initStatic() {
       DySmsHelper.setAccessKeyId(accessKeyId);
       DySmsHelper.setAccessKeySecret(accessKeySecret);
       EmailSendMsgHandle.setEmailFrom(emailFrom);
    }*/

}
