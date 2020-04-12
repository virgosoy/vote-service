package com.zsy.voteservice.dao;


import com.zsy.voteservice.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Soy
 * @date 2020-3-22
 */
public interface UserDao extends JpaRepository<UserDO, Integer> {
    Boolean existsByLoginName(String loginName);
    UserDO getByLoginName(String loginName);
}
