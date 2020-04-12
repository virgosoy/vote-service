package com.zsy.voteservice.service;

import com.zsy.voteservice.entity.UserDO;
import com.zsy.voteservice.rest.user.param.UserLoginReq;
import com.zsy.voteservice.service.interfaces.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void mineInfo(){
        UserDO userDO = new UserDO();
        userDO.setId(1);
        UserDO result = userService.mineInfo(userDO);
        System.out.println(result);
    }

    @Test
    void create() {
        UserDO user = new UserDO();
        user.setLoginName("w");
        user.setPassword("123");
        user.setUserName("老王");
        UserDO userDO = userService.create(user);
        assertEquals(1,userDO.getId());
    }

    @Test
    void login() {
        create();
        UserLoginReq userLoginReq = new UserLoginReq();
        userLoginReq.setLoginName("w");
        userLoginReq.setPassword("123");

        UserDO user = userService.login(userLoginReq);
        assertEquals(1,user.getId());

    }
}