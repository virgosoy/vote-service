package com.zsy.voteservice.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 单个投票活动
 * @author Soy
 * @date 2020-3-22
 */
@Data
@Entity
@Table(name = "vote_question")
@EntityListeners(AuditingEntityListener.class)
public class VoteQuestionDO {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column
    private String description;
    @Column(nullable = false)
    private LocalDateTime startTime;
    @Column(nullable = false)
    private LocalDateTime endTime;
    @Column(name = "is_anonymous",nullable = false)
    private Boolean anonymous;
    @Column
    private String creator;
    @Column
    private String modifier;
    @Column(name = "is_delete",nullable = false)
    private Boolean delete;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createTime;
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updateTime;
}
