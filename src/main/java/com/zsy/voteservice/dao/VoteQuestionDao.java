package com.zsy.voteservice.dao;

import com.zsy.voteservice.entity.VoteQuestionDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Soy
 * @date 2020-3-28
 */
public interface VoteQuestionDao extends JpaRepository<VoteQuestionDO, Integer> {

}
