package com.zsy.voteservice.rest.vote.param;

import com.zsy.voteservice.common.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Soy
 * @date 2020-3-28
 */
@Data
public class VoteOptionReq extends BaseRequest implements Serializable {
    static final long serialVersionUID = 1L;

    @ApiModelProperty("问卷id")
    private Integer questionId;
    @ApiModelProperty("选项名称")
    private String name;
    @ApiModelProperty("选项描述")
    private String description;
    @ApiModelProperty("图片列表")
    private List<Integer> imageIdList;

}
