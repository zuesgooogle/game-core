package com.simplegame.core.data.accessor.dao;

import java.util.List;

import com.simplegame.core.data.IEntity;
import com.simplegame.core.data.IQueryFilter;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月21日 下午4:54:21
 *
 */

public interface ICacheInitDaoOperation<T extends IEntity> {

    public abstract T loadCacheFromDb(String id);

    public abstract List<T> loadCachesFromDb(String id);

    public abstract T cacheLoad(Object paramObject, String id);

    public abstract List<T> cacheLoadAll(String id);

    public abstract List<T> cacheLoadAll(String id, IQueryFilter queryFilter);

    public abstract Object cacheInsert(T t, String id);

    public abstract int cacheUpdate(T t, String id);

    public abstract int cacheDelete(Object paramObject, String id);


	
}
