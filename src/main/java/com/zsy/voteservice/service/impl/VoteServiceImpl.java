package com.zsy.voteservice.service.impl;

import com.zsy.voteservice.constant.SessionKeyConstants;
import com.zsy.voteservice.dao.FileDao;
import com.zsy.voteservice.dao.VoteOptionDao;
import com.zsy.voteservice.dao.VoteQuestionDao;
import com.zsy.voteservice.entity.FileDO;
import com.zsy.voteservice.entity.UserDO;
import com.zsy.voteservice.entity.VoteOptionDO;
import com.zsy.voteservice.entity.VoteQuestionDO;
import com.zsy.voteservice.enums.BusinessExceptionEnum;
import com.zsy.voteservice.except.ServiceException;
import com.zsy.voteservice.rest.vote.param.VoteOptionReq;
import com.zsy.voteservice.rest.vote.param.VoteQuestionReq;
import com.zsy.voteservice.service.interfaces.VoteService;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Soy
 * @date 2020-3-28
 */
@Service
public class VoteServiceImpl implements VoteService {
    private static final Logger logger = LoggerFactory.getLogger(VoteServiceImpl.class);

    @Value("${custom.upload.folder}")
    private String uploadFolder;

    @Autowired
    private VoteQuestionDao voteQuestionDao;
    @Autowired
    private VoteOptionDao voteOptionDao;
    @Autowired
    private FileDao fileDao;

    @Override
    public Boolean vote(Integer voteItemId) {
        return null;
    }

    @Override
    public VoteQuestionDO createVoteQuestion(VoteQuestionReq voteQuestionReq) {
        VoteQuestionDO voteQuestionDO = new VoteQuestionDO();
        BeanUtils.copyProperties(voteQuestionReq, voteQuestionDO);
        voteQuestionDO.setDelete(false);
        VoteQuestionDO result = voteQuestionDao.save(voteQuestionDO);
        return result;
    }

    @Override
    public VoteOptionDO createVoteItem(VoteOptionDO voteOptionDO) {
        return null;
    }

    @Override
    public VoteOptionDO getVoteItem(VoteOptionDO voteOptionDO) {
        return null;
    }

    @Override
    public List<VoteOptionDO> listVoteItem(VoteQuestionDO voteQuestionDO) {
        return null;
    }

    @Override
    public List<VoteQuestionDO> listVoteHeader() {
        return null;
    }

    @Override
    public FileDO uploadOptionImage(Integer userId, MultipartFile file) {
        if(file.isEmpty()){
            throw BusinessExceptionEnum.FILE_EMPTY.exception();
        }

        String fileName = UUID.randomUUID().toString();
        Path path = Paths.get(uploadFolder, fileName);
        try {
            Files.write(path, file.getBytes());
        } catch (IOException e) {
            throw new ServiceException("写入文件到系统失败", e);
        }
        FileDO fileDO = new FileDO();
        String originalFilename = file.getOriginalFilename();
        UserDO userDO = new UserDO();
        userDO.setId(userId);
        fileDO.setUser(userDO);
        fileDO.setName(FilenameUtils.getBaseName(originalFilename));
        fileDO.setSuffix(FilenameUtils.getExtension(originalFilename));
        fileDO.setFilePath(fileName);
        return fileDao.save(fileDO);
    }

    @Override
    public VoteOptionDO insertVoteOption(VoteOptionReq voteOptionReq) {
        VoteOptionDO voteOptionDO = new VoteOptionDO();
        BeanUtils.copyProperties(voteOptionReq, voteOptionDO);
        UserDO userDO = new UserDO();
        userDO.setId(voteOptionReq.getUserId());
        voteOptionDO.setUser(userDO);

        VoteQuestionDO question = new VoteQuestionDO();
        question.setId(voteOptionReq.getQuestionId());

        voteOptionDO.setQuestion(question);

        return voteOptionDao.save(voteOptionDO);
    }
}
