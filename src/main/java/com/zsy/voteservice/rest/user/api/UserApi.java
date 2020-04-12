package com.zsy.voteservice.rest.user.api;

import com.zsy.voteservice.constant.SessionKeyConstants;
import com.zsy.voteservice.entity.UserDO;
import com.zsy.voteservice.common.Response;
import com.zsy.voteservice.enums.BusinessExceptionEnum;
import com.zsy.voteservice.rest.user.param.UserLoginReq;
import com.zsy.voteservice.rest.user.vo.UserVO;
import com.zsy.voteservice.rest.user.param.UserRegisterReq;
import com.zsy.voteservice.service.interfaces.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * @author Soy
 * @date 2020-3-25
 */
@RestController
@RequestMapping("/api/v1/user")
@Api(tags = "用户接口")
public class UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @PostMapping("/register")
    @ApiOperation(value = "注册（创建用户）")
    public Response<UserVO> register(UserRegisterReq userRegisterReq){
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userRegisterReq,userDO);
        UserDO result = userService.create(userDO);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(result,userVO);
        return Response.success(userVO);
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Response<UserVO> login(UserLoginReq userLoginReq){
        UserDO userDO = userService.login(userLoginReq);
        // 登录成功，数据存放到session中
        session.setAttribute(SessionKeyConstants.USER, userDO);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDO, userVO);
        return Response.success(userVO);
    }

    @GetMapping("/mine")
    @ApiOperation("获取当前登录用户信息")
    public Response<UserVO> mine(){

        UserDO userDO = userService.mineInfo((UserDO) session.getAttribute(SessionKeyConstants.USER));
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDO, userVO);
        return Response.success(userVO);
    }

    @GetMapping("/logout")
    @ApiOperation("用户登出（幂等）")
    public Response logout(){
        session.removeAttribute(SessionKeyConstants.USER);
        return Response.success();
    }

    @PutMapping("/password")
    @ApiOperation("修改当前用户密码")
    public Response changePassword(@ApiParam("旧密码") @RequestParam String oldPassword,
                                   @ApiParam("新密码") @RequestParam String newPassword){
        UserDO sessionUser = (UserDO) Optional.ofNullable(session.getAttribute(SessionKeyConstants.USER))
                .orElseThrow(BusinessExceptionEnum.USER_NOT_LOGIN::exception);
        userService.changePassword(sessionUser.getId(), oldPassword, newPassword);
        return Response.success();
    }
}
