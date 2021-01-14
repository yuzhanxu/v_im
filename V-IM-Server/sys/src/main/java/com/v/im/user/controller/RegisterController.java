package com.v.im.user.controller;

import com.v.im.common.exception.ResultCodeEnum;
import com.v.im.common.exception.VimException;
import com.v.im.user.entity.ImUser;
import com.v.im.user.service.IImUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 注册
 *
 * @author 乐天
 * @since 2018-10-07
 */
@RestController
public class RegisterController {

    @Resource
    @Qualifier(value = "imUserService")
    private IImUserService imUserService;

    /**
     * 用户注册
     *
     * @param name     用户名
     * @param password 密码
     * @param phone    手机
     * @return 结果
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public boolean register(String name, String password, String phone) {
        if (imUserService.getByLoginName(phone) != null) {
            throw new VimException(ResultCodeEnum.SMS_ERROR_REGISTER);
        } else {
            try {
                ImUser imUser = new ImUser();
                String finalSecret = "{bcrypt}" + new BCryptPasswordEncoder().encode(password.trim());
                imUser.setPassword(finalSecret);
                imUser.setLoginName(phone);
                imUser.setMobile(phone);
                imUser.setName(name);
                imUser.setAvatar("/img/default-user.png");
                return imUserService.registerUser(imUser);
            } catch (Exception e) {
                throw new VimException(ResultCodeEnum.SAME_PHONE);
            }
        }
    }
}
