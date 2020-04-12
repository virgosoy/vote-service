package com.zsy.voteservice.rest.vote.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Soy
 * @date 2020-3-29
 */
@Data
public class FileVO implements Serializable {
    static final long serialVersionUID = 1L;
    @ApiModelProperty("文件id")
    private Integer id;
    @ApiModelProperty("文件相对路径")
    private String filePath;
}
