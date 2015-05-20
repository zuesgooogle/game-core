package com.simplegame.core.data.accessor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author zeusgooogle
 * @date 2014-10-2 下午08:04:02
 */
public class AccessorManager implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private String defaultAccessType;

    public Map<String, String> accessors = new HashMap<String, String>();

    public AccessorManager() {
    }

    public void setAccessors(Map<String, String> paramMap) {
        this.accessors = paramMap;
    }

    public void setDefaultDbType(String paramString) {
        this.defaultAccessType = paramString;
    }

    public IDbAccessor getAccessor(String paramString) {
        IDbAccessor localIDbAccessor = (IDbAccessor) this.applicationContext.getBean((String) this.accessors.get(paramString), IDbAccessor.class);
        if (null == localIDbAccessor) {
            throw new NullPointerException("no accessor type:" + paramString);
        }
        return localIDbAccessor;
    }

    public String getDefaultAccessType() {
        return this.defaultAccessType;
    }

    public void setApplicationContext(ApplicationContext paramApplicationContext) throws BeansException {
        this.applicationContext = paramApplicationContext;
    }
}
