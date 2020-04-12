package com.zsy.voteservice.rest.user.param;

import com.zsy.voteservice.common.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Soy
 * @date 2020-3-25
 */
@Data
public class UserRegisterReq extends BaseRequest implements Serializable {
    static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "登录名",required = true)
    private String loginName;
    @ApiModelProperty(value = "用户名",required = true)
    private String userName;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}
