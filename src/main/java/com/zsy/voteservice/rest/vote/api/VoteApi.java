package com.zsy.voteservice.rest.vote.api;

import com.zsy.voteservice.constant.SessionKeyConstants;
import com.zsy.voteservice.entity.FileDO;
import com.zsy.voteservice.entity.UserDO;
import com.zsy.voteservice.entity.VoteOptionDO;
import com.zsy.voteservice.entity.VoteQuestionDO;
import com.zsy.voteservice.common.Response;
import com.zsy.voteservice.enums.BusinessExceptionEnum;
import com.zsy.voteservice.rest.vote.param.VoteOptionReq;
import com.zsy.voteservice.rest.vote.param.VoteQuestionReq;
import com.zsy.voteservice.rest.vote.vo.FileVO;
import com.zsy.voteservice.service.interfaces.VoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * @author Soy
 * @date 2020-3-28
 */
@Api(tags = "投票接口")
@RestController
@RequestMapping("/api/v1/vote")
public class VoteApi {
    private static final Logger logger = LoggerFactory.getLogger(VoteApi.class);

    @Autowired
    private VoteService voteService;

    @Autowired
    private HttpSession session;

    @ApiOperation("创建投票")
    @PostMapping("/question")
    public Response<VoteQuestionDO> voteCreate(VoteQuestionReq voteQuestionReq){
        VoteQuestionDO voteQuestion = voteService.createVoteQuestion(voteQuestionReq);
        return Response.success(voteQuestion);
    }

    @ApiOperation("增加投票选项")
    @PostMapping("/option")
    public Response<VoteOptionDO> voteOptionAdd(VoteOptionReq voteOptionReq){
        UserDO user = (UserDO) Optional.ofNullable(session.getAttribute(SessionKeyConstants.USER))
                .orElseThrow(BusinessExceptionEnum.USER_NOT_LOGIN::exception);
        voteOptionReq.setUserId(user.getId());
        voteService.insertVoteOption(voteOptionReq);
        return null;
    }

    @ApiOperation("上传投票显示中的图片")
    @PostMapping("/optionImage")
    public Response<FileVO> uploadOptionImage(@RequestParam("image")MultipartFile file){

        UserDO user = (UserDO) Optional.ofNullable(session.getAttribute(SessionKeyConstants.USER))
                .orElseThrow(BusinessExceptionEnum.USER_NOT_LOGIN::exception);
        FileDO fileDO = voteService.uploadOptionImage(user.getId(), file);
        FileVO fileVO = new FileVO();
        BeanUtils.copyProperties(fileDO, fileVO);
        return Response.success(fileVO);
    }

}
