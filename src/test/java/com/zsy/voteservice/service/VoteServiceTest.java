package com.zsy.voteservice.service;

import com.zsy.voteservice.entity.VoteOptionDO;
import com.zsy.voteservice.rest.vote.param.VoteOptionReq;
import com.zsy.voteservice.service.interfaces.VoteService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class VoteServiceTest {

    @Autowired
    private VoteService voteService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insertVoteOption() {
        VoteOptionReq voteOptionReq = new VoteOptionReq();
        voteOptionReq.setName("选项名");
        voteOptionReq.setDescription("描述");
        voteOptionReq.setQuestionId(1);
        voteOptionReq.setImageIdList(Arrays.asList(1,2,3));
        VoteOptionDO voteOptionDO = voteService.insertVoteOption(voteOptionReq);
        System.out.println(voteOptionDO);
    }
}