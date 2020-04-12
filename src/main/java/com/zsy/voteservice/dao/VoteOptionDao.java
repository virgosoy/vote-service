package com.zsy.voteservice.dao;

import com.zsy.voteservice.entity.VoteOptionDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Soy
 * @date 2020-3-29
 */
public interface VoteOptionDao extends JpaRepository<VoteOptionDO, Integer> {
}
