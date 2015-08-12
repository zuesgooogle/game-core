package com.simplegame.core.data.accessor.dao;

import java.util.List;

import com.simplegame.core.data.IEntity;
import com.simplegame.core.data.IQueryFilter;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月21日 下午4:54:21
 * 
 */

public interface ICacheInitDaoOperation<T extends IEntity> {

    public T loadCacheFromDb(String id);

    public List<T> loadCachesFromDb(String id);

    public T cacheLoad(Object paramObject, String id);

    public List<T> cacheLoadAll(String id);

    public List<T> cacheLoadAll(String id, IQueryFilter queryFilter);

    public Object cacheInsert(T t, String id);

    public int cacheUpdate(T t, String id);

    public int cacheDelete(Object paramObject, String id);

}
