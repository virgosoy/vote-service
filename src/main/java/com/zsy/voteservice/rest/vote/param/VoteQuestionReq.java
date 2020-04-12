package com.zsy.voteservice.rest.vote.param;

import com.zsy.voteservice.common.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Soy
 * @date 2020-3-28
 */
@Data
public class VoteQuestionReq extends BaseRequest implements Serializable {
    static final long serialVersionUID = 1L;

    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("投票开始时间")
    private LocalDateTime startTime;
    @ApiModelProperty("投票结束时间")
    private LocalDateTime endTime;
    @ApiModelProperty("是否匿名")
    private Boolean anonymous;
}
