package com.zsy.voteservice.dao;

import com.zsy.voteservice.entity.VoteQuestionDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VoteHeaderDaoTest {
    @Autowired
    private VoteQuestionDao voteQuestionDao;
    @Test
    void save(){
        VoteQuestionDO voteHeaderDTO = new VoteQuestionDO();
        voteHeaderDTO.setAnonymous(false);
        voteHeaderDTO.setTitle("你好");
        voteHeaderDTO.setStartTime(LocalDateTime.now());
        voteHeaderDTO.setEndTime(LocalDateTime.now());
        voteHeaderDTO.setCreator("老王");
        voteHeaderDTO.setModifier("老王");
        voteHeaderDTO.setDelete(false);

        VoteQuestionDO save = voteQuestionDao.save(voteHeaderDTO);
        Integer id = save.getId();
        assertEquals(1,id);
    }

}