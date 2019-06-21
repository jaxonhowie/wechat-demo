package com.em.controller;


import com.em.util.EncryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author Hongyi Zheng
 * @date 2019-06-21
 */
@RestController
public class AuthTokenController {

    private static final String TOKEN = "wechat";

    private static final Logger LOG = LoggerFactory.getLogger(AuthTokenController.class);

    /**
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   随机字符串
     * @return
     */
    @GetMapping("/wx")
    public String validServer(@RequestParam(value = "signature") String signature,
                                  @RequestParam(value = "timestamp") String timestamp,
                                  @RequestParam(value = "nonce") String nonce,
                                  @RequestParam(value = "echostr") String echostr) {
        String[] arr = new String[]{TOKEN, timestamp, nonce};
        //字典序排序
        Arrays.sort(arr);
        String tempSign = Arrays.toString(arr);
        String sign = EncryptUtils.sha1(tempSign.substring(1, tempSign.length() - 1));
        LOG.info("signature == {}, sign ={}", signature, sign);
        if (signature.equals(sign)){
            return echostr;
        }else {
            return "wrong str";
        }
    }
}
