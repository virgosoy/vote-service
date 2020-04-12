package com.zsy.voteservice.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Soy
 * @date 2020-3-22
 */
@Data
@Entity
@Table(name = "vote_option_image")
@EntityListeners(AuditingEntityListener.class)
public class VoteOptionImageDO {
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 排序
     */
    @Column
    private Integer order;
    @ManyToOne
    private FileDO file;
    @ManyToOne
    private VoteOptionDO option;
    @Column
    @CreatedDate
    private LocalDateTime createTime;
    @Column
    @LastModifiedDate
    private LocalDateTime updateTime;
}
