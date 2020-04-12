package com.zsy.voteservice.rest.user.api;

import com.zsy.voteservice.common.Response;
import com.zsy.voteservice.rest.user.vo.UserVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserApiTest {

    @Autowired
    private UserApi userApi;

    @Test
    void mine(){
        Response<UserVO> mine = userApi.mine();
        System.out.println(mine);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}