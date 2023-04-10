package org.jeecg.common.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.ClientException;
import org.jeecg.config.StaticConfig2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 17/6/7.
 * 短信API产品的DEMO程序,工程中包含了一个SmsDemo类，直接通过
 * 执行main函数即可体验短信产品API功能(只需要将AK替换成开通了云通信-短信产品功能的AK即可)
 * 工程依赖了2个jar包(存放在工程的libs目录下)
 * 1:aliyun-java-sdk-core.jar
 * 2:aliyun-java-sdk-dysmsapi.jar
 * <p>
 * 备注:Demo工程编码采用UTF-8
 * 国际短信发送请勿参照此DEMO
 *
 * @author: jeecg-boot
 */
public class DySmsHelper2 {

    private final static Logger logger = LoggerFactory.getLogger(DySmsHelper2.class);

    /**
     * TODO 此处需要替换成开发者自己的
     */
    static String sp_id;
    static String password;
    static String url;

    public static String getSp_id() {
        return sp_id;
    }

    public static void setSp_id(String sp_id) {
        DySmsHelper2.sp_id = sp_id;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DySmsHelper2.password = password;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        DySmsHelper2.url = url;
    }

    public static boolean sendSms(String mobile, String captcha) throws ClientException {
        //可自助调整超时时间
//        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
//        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //update-begin-author：taoyan date:20200811 for:配置类数据获取
        StaticConfig2 staticConfig2 = SpringContextUtils.getBean(StaticConfig2.class);
        setSp_id(staticConfig2.getSp_id());
        setPassword(staticConfig2.getPassword());
        setUrl(staticConfig2.getUrl());

        try {
            RestTemplate restTemplate = new RestTemplate();
            // 请求地址
            // String url = "http://jsonplaceholder.typicode.com/posts";
            // 请求头设置,x-www-form-urlencoded格式的数据
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            //提交参数设置
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("sp_id", sp_id);
            map.add("password", password);
            map.add("mobile", mobile);
            map.add("content", "【靖凯开源】您的验证码为：" + captcha + "，请勿泄露于他人！");
            // 组装请求体
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
            // 发送post请求，并打印结果，以String类型接收响应结果JSON字符串
            String result = restTemplate.postForObject(url, request, String.class);
            JSONObject jsonObject = JSON.parseObject(result);
            logger.info("短信接口返回的数据----------------");
            logger.info(result);
            if ("0".equals(jsonObject.get("code").toString())) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }


//    public static void main(String[] args) throws ClientException, InterruptedException {
//    	JSONObject obj = new JSONObject();
//    	obj.put("code", "1234");
//    	sendSms("13800138000", obj, DySmsEnum.FORGET_PASSWORD_TEMPLATE_CODE);
//    }
}
