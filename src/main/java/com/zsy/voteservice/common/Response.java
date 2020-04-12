package com.zsy.voteservice.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Soy
 * @date 2020-3-25
 */
@Data
public class Response<T> implements Serializable {
    @ApiModelProperty("是否业务成功")
    private Boolean success;
    /**
     * 0成功，其他失败
     */
    @ApiModelProperty("结果代码")
    private Integer resultCode;

    @ApiModelProperty("结果信息")
    private String resultMessage;

    @ApiModelProperty("异常时堆栈")
    private Object info;

    @ApiModelProperty("业务数据")
    private T result;

    /**
     * 默认构造函数
     */
    public Response() {
    }

    /**
     * 构造函数
     * @param success 是否成功
     * @param resultCode 结果代码
     * @param resultMessage 结果信息
     */
    public Response(Boolean success, Integer resultCode, String resultMessage) {
        this.success = success;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    /**
     * 构造函数
     * @param success 是否成功
     * @param resultCode 结果代码
     * @param resultMessage 结果信息
     * @param info 异常时堆栈信息
     */
    public Response(Boolean success, Integer resultCode, String resultMessage, Object info) {
        this.success = success;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.info = info;
    }

    /**
     * 构造函数
     * @param success 是否成功
     * @param resultCode 结果代码
     * @param resultMessage 结果信息
     * @param info 异常时堆栈信息
     * @param result 业务执行结果
     */
    public Response(Boolean success, Integer resultCode, String resultMessage, Object info, T result) {
        this.success = success;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.info = info;
        this.result = result;
    }

    /**
     * 成功返回，无结果集
     * @return
     */
    public static Response<Object> success(){
        return new Response<>(true,0,"成功",null,null);
    }

    /**
     * 成功返回结果集
     * @param result
     * @param <T>
     * @return
     */
    public static <T> Response<T> success(T result){
        return new Response<>(true,0,"成功",null,result);
    }

    /**
     * 异常返回错误
     * @param resultCode 错误代码
     * @param resultMessage 错误信息
     * @return
     */
    public static Response<Object> error(Integer resultCode, String resultMessage){
        return new Response<>(false, resultCode, resultMessage,null,null);
    }
}
