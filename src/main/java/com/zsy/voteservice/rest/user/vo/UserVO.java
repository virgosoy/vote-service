package com.zsy.voteservice.rest.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Soy
 * @date 2020-3-26
 */
@Data
public class UserVO implements Serializable {
    static final long serialVersionUID = 1L;

    @ApiModelProperty("登录名")
    private String loginName;
    @ApiModelProperty("用户名")
    private String userName;
}
