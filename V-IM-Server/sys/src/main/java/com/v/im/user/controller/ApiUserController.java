package com.v.im.user.controller;

import com.v.im.common.utils.ChatUtils;
import com.v.im.user.UserUtils;
import com.v.im.user.entity.ImUser;
import com.v.im.user.service.IImUserFriendService;
import com.v.im.user.service.IImUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class ApiUserController {

    @Resource
    @Qualifier(value = "imUserService")
    private IImUserService imUserService;

    @Resource
    @Qualifier(value = "imUserFriendService")
    private IImUserFriendService imUserFriendService;

    /**
     * 用户信息初始化
     *
     * @param request request
     * @return json
     */
    @GetMapping("init")
    public Map<String, Object> init(HttpServletRequest request) {
        Map<String, Object> objectMap = new HashMap<>();
        //获取好友信息
        ImUser user = UserUtils.getUser();
        objectMap.put("friends", imUserFriendService.getUserFriends(user.getId()));

        //获取本人信息
        String host = ChatUtils.getHost(request);
        user.setAvatar(host + user.getAvatar());
        user.setPassword(null);
        objectMap.put("me", user);

        //用户的群信息
        objectMap.put("groups", imUserService.getChatGroups(user.getId()));
        return objectMap;
    }


    /**
     * 获取群组的用户
     *
     * @param chatId 群组id
     * @return 用户List
     */
    @GetMapping("chatUserList")
    public List<ImUser> chatUserList(String chatId) {
        return imUserService.getChatUserList(chatId);
    }

    /**
     * 单个用户
     *
     * @param id userId
     * @return ImUser
     */
    @GetMapping("{id}")
    public ImUser get(@PathVariable String id) {
        return imUserService.getById(id);
    }

    @DeleteMapping("{id}")
    public ImUser delete(@PathVariable String id) {
        return imUserService.getById(id);
    }

}
