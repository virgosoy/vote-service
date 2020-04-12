package com.zsy.voteservice.rest.user.param;

import com.zsy.voteservice.common.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Soy
 * @date 2020-3-28
 */
@Data
public class UserLoginReq extends BaseRequest implements Serializable {
    static final long serialVersionUID = 1L;

    @ApiModelProperty("登录名")
    private String loginName;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("验证码")
    private String captcha;
}
