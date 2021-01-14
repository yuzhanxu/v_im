package com.v.im.user.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 退出登录
 *
 * @author 乐天
 * @since 2018-10-07
 */
@RestController
@RequestMapping("/oauth")
public class LogoutController {

    @Resource
    @Qualifier("consumerTokenServices")
    ConsumerTokenServices consumerTokenServices;

    /**
     * 退出登录功能
     *
     * @param access_token token
     * @return json
     */
    @RequestMapping("/logout")
    public boolean revokeToken(String access_token) {
        if (consumerTokenServices.revokeToken(access_token)) {
            return true;
        } else {
            return false;
        }
    }
}
