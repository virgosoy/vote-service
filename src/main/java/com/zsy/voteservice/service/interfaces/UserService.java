package com.zsy.voteservice.service.interfaces;

import com.zsy.voteservice.entity.UserDO;
import com.zsy.voteservice.rest.user.param.UserLoginReq;

/**
 * @author Soy
 * @date 2020-3-22
 */
public interface UserService {
    /**
     * 创建用户
     * @param user
     * @return
     */
    UserDO create(UserDO user);

    /**
     * 用户登录
     *
     * @param userloginReq@return
     */
    UserDO login(UserLoginReq userloginReq);

    /**
     * 当前登录用户信息
     * @return
     */
    UserDO mineInfo(UserDO userDO);


    /**
     * 修改当前用户密码
     * @param userId
     * @param oldPassword
     * @param newPassword
     */
    void changePassword(Integer userId, String oldPassword, String newPassword);
}
