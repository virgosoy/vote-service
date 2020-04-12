package com.zsy.voteservice.service.interfaces;

import com.zsy.voteservice.entity.FileDO;
import com.zsy.voteservice.entity.VoteQuestionDO;
import com.zsy.voteservice.entity.VoteOptionDO;
import com.zsy.voteservice.rest.vote.param.VoteOptionReq;
import com.zsy.voteservice.rest.vote.param.VoteQuestionReq;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Soy
 * @date 2020-3-28
 */
public interface VoteService {
    /**
     * 投票
     * @param voteItemId 投给的项目id
     * @return
     */
    Boolean vote(Integer voteItemId);

    /**
     * 创建投票
     * @param voteQuestionReq
     * @return
     */
    VoteQuestionDO createVoteQuestion(VoteQuestionReq voteQuestionReq);

    /**
     * 创建投票项目
     * @param voteOptionDO
     * @return
     */
    VoteOptionDO createVoteItem(VoteOptionDO voteOptionDO);

    /**
     * 查询项目结果
     * @param voteOptionDO
     * @return
     */
    VoteOptionDO getVoteItem(VoteOptionDO voteOptionDO);

    /**
     * 获取投票内容
     * @param voteQuestionDO
     * @return
     */
    List<VoteOptionDO> listVoteItem(VoteQuestionDO voteQuestionDO);

    /**
     * 获取所有投票列表
     * @return
     */
    List<VoteQuestionDO> listVoteHeader();

    /**
     * 上传选项图片
     *
     * @param userId
     * @param file
     * @return
     */
    FileDO uploadOptionImage(Integer userId, MultipartFile file);

    /**
     * 插入投票选项
     * @param voteOptionReq
     * @return
     */
    VoteOptionDO insertVoteOption(VoteOptionReq voteOptionReq);
}
