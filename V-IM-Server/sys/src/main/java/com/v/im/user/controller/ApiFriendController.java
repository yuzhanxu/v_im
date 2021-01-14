package com.v.im.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.v.im.common.exception.ResultCodeEnum;
import com.v.im.common.exception.VimException;
import com.v.im.user.UserUtils;
import com.v.im.user.entity.ImUser;
import com.v.im.user.entity.ImUserFriend;
import com.v.im.user.service.IImUserFriendService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/friend")
public class ApiFriendController {


    @Resource
    @Qualifier(value = "imUserFriendService")
    private IImUserFriendService imUserFriendService;

    /**
     * 用户信息初始化
     *
     * @param userId 用户id
     * @return json
     */
    @GetMapping("{userId}")
    public List<ImUser> get(@PathVariable String userId) {
        return imUserFriendService.getUserFriends(userId);
    }

    /**
     * 添加朋友
     *
     * @param friendId 好友id
     * @return boolean
     */
    @PostMapping("{friendId}")
    public boolean save(@PathVariable String friendId) {
        String userId = UserUtils.getUser().getId();

        ImUserFriend friend = new ImUserFriend();
        friend.setFriendId(friendId);
        friend.setUserId(userId);
        friend.setCreateBy(userId);
        friend.setUpdateBy(userId);
        friend.preInsert();
        try {
            return imUserFriendService.save(friend);
        } catch (DuplicateKeyException e) {
            throw new VimException(ResultCodeEnum.DUPLICATE_KEY_EXCEPTION);
        }
    }

    /**
     * 删除好友
     *
     * @param friendId 好友id
     * @return boolean
     */
    @DeleteMapping("{friendId}")
    public boolean delete(@PathVariable String friendId) {
        QueryWrapper<ImUserFriend> wrapper = new QueryWrapper<>();
        wrapper.eq("friend_id", friendId);
        wrapper.eq("user_id", UserUtils.getUser().getId());
        return imUserFriendService.remove(wrapper);
    }

}
