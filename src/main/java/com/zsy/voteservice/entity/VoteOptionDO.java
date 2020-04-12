package com.zsy.voteservice.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 投票项目（每个项目就是一个作品）
 * @author Soy
 * @date 2020-3-22
 */
@Data
@Entity
@Table(name = "vote_option")
@EntityListeners(AuditingEntityListener.class)
public class VoteOptionDO {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private VoteQuestionDO question;
    @ManyToOne
    private UserDO user;
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    /**
     * 总票数，冗余字段
     */
    @Column
    private Integer totalVotes;
    @Column
    @CreatedDate
    private LocalDateTime createTime;
    @Column
    @LastModifiedDate
    private LocalDateTime updateTime;
}
