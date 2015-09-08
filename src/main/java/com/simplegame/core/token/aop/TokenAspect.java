package com.simplegame.core.token.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.simplegame.core.token.TokenManager;
import com.simplegame.core.token.annotation.TokenCheck;

import com.simplegame.protocol.message.Message;

/**
 * @author zeusgooogle
 * @date 2014-9-30 下午04:52:27
 */
public class TokenAspect {

    private Logger LOG = LogManager.getLogger(TokenAspect.class);

    private TokenManager tokenManager;

    public TokenAspect() {
    }

    public void setTokenManager(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    public void check(ProceedingJoinPoint joinPoint, TokenCheck tokenCheck) {
        try {
            String component = tokenCheck.component();
            Message localMessage = (Message) joinPoint.getArgs()[0];
            
            Object[] token = localMessage.getToken();
            if (null != token) {
                String taskId = (String) token[0];
                Long time = (Long) token[1];
                
                if (this.tokenManager.checkToken(time, component, taskId)) {
                    this.tokenManager.removeToken(component, taskId);
                    
                    joinPoint.proceed();
                }
            } else {
                throw new RuntimeException("no token to be checked.");
            }
        } catch (Throwable localThrowable) {
            this.LOG.error("error in token check invoke", localThrowable);
            throw new RuntimeException("error in token check invoke", localThrowable);
        }
    }

}
