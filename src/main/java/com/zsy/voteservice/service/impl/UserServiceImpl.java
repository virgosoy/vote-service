package com.zsy.voteservice.service.impl;

import com.zsy.voteservice.enums.BusinessExceptionEnum;
import com.zsy.voteservice.constant.SessionKeyConstants;
import com.zsy.voteservice.dao.UserDao;
import com.zsy.voteservice.entity.UserDO;
import com.zsy.voteservice.except.ServiceException;
import com.zsy.voteservice.rest.user.param.UserLoginReq;
import com.zsy.voteservice.service.interfaces.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

/**
 * @author Soy
 * @date 2020-3-22
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;


    /**
     * 密码加密
     * @param unencodedPassword 未加密的密码
     * @param salt 盐值
     * @return 加密后的密码
     */
    private String encodePassword(String unencodedPassword,String salt){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return Base64.getEncoder().encodeToString(
                    messageDigest.digest(
                            (unencodedPassword + salt).getBytes(
                                    StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException("加密异常",e);
        }
    }

    @Override
    public UserDO create(UserDO user) {
        Boolean isExist = userDao.existsByLoginName(user.getLoginName());
        if(isExist){
            throw BusinessExceptionEnum.USER_LOGIN_NAME_EXIST.exception();
        }
        String salt = RandomStringUtils.randomAlphanumeric(10);
        user.setSalt(salt);
        String unencodedPassword = user.getPassword();
        user.setPassword(encodePassword(unencodedPassword,salt));
        return userDao.save(user);
    }

    @Override
    public UserDO login(UserLoginReq userloginReq) {
        UserDO user = Optional.ofNullable(userDao.getByLoginName(userloginReq.getLoginName()))
                .orElseThrow(BusinessExceptionEnum.USER_LOGIN_UNKNOWN_ACCOUNT::exception);
        if(!checkPassword(userloginReq.getPassword(), user)){
            throw BusinessExceptionEnum.USER_LOGIN_NAME_OR_PASSWORD_WRONG.exception();
        }
        return user;
    }

    @Override
    public UserDO mineInfo(UserDO userDO) {
        return Optional.ofNullable(userDO)
                .orElseThrow(BusinessExceptionEnum.USER_NOT_LOGIN::exception);
    }

    @Override
    public void changePassword(Integer userId, String oldPassword, String newPassword) {
        UserDO dbUser = userDao.getOne(userId);
        if(!checkPassword(oldPassword, dbUser)){
            throw BusinessExceptionEnum.USER_PASSWORD_WRONG.exception();
        }
        String salt = RandomStringUtils.randomAlphanumeric(10);
        dbUser.setSalt(salt);
        dbUser.setPassword(encodePassword(newPassword, salt));
        userDao.save(dbUser);
    }

    /**
     * 判断密码是否正确
     * @param password
     * @param user
     * @return
     */
    private boolean checkPassword(String password, UserDO user) {
        return encodePassword(password, user.getSalt()).equals(user.getPassword());
    }

}
