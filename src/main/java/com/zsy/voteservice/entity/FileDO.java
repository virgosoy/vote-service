package com.zsy.voteservice.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 记录上传的文件
 * @author Soy
 * @date 2020-3-29
 */
@Data
@Entity
@Table(name = "file")
@EntityListeners(AuditingEntityListener.class)
public class FileDO {
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 文件相对路径
     */
    @Column(nullable = false,unique = true)
    private String filePath;
    @Column
    private String name;
    @Column
    private String suffix;
    @Column
    @CreatedDate
    private LocalDateTime createTime;
    @ManyToOne
    private UserDO user;
}
