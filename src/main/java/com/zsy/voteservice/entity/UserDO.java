package com.zsy.voteservice.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 用户
 * @author Soy
 * @date 2020-3-22
 */
@Data
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String loginName;
    @Column(nullable = false)
    private String userName;
    @Column
    private String password;
    @Column(nullable = false)
    private String salt;
    @Column
    @CreatedDate
    private LocalDateTime createTime;
    @Column
    @LastModifiedDate
    private LocalDateTime updateTime;
}
