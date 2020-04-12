package com.zsy.voteservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 投票结果（谁投给谁）
 * @author Soy
 * @date 2020-3-22
 */
@Data
@Entity
@Table(name = "vote_record")
public class VoteRecordDO {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private VoteOptionDO option;
    @ManyToOne
    private UserDO user;
    @Column
    private LocalDateTime voteTime;
}
