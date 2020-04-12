package com.zsy.voteservice.common;

import com.zsy.voteservice.constant.ResultCodeConstants;
import com.zsy.voteservice.except.BusinessException;
import com.zsy.voteservice.except.DAOException;
import com.zsy.voteservice.except.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 * @author Soy
 * @date 2020-3-28
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 可以返回给前端的异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Response<Object> businessException(BusinessException ex){
        // 记录日志
        logger.warn("BusinessException:{}", ex.getMessage(), ex);
        // 返回结果给前端
        return Response.error(ex.getErrorCode(), ex.getMessage());
    }

    @ExceptionHandler
    public Response<Object> exception(Exception ex){
        String logMsg = "Unknown Exception:{}";
        if(ex instanceof ServiceException){
            logMsg = "ServiceException:{}";
        }else if(ex instanceof DAOException){
            logMsg = "DAOException:{}";
        }
        logger.error(logMsg, ex.getMessage(), ex);
        return Response.error(ResultCodeConstants.UNKNOWN_EXCEPTION,"未知异常，请联系管理员");
    }
}
