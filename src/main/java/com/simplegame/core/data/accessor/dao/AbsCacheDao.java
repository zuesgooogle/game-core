package com.simplegame.core.data.accessor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simplegame.core.data.IEntity;
import com.simplegame.core.data.IQueryFilter;
import com.simplegame.core.data.accessor.AccessType;
import com.simplegame.core.data.accessor.IDbAccessor;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月21日 下午5:41:56
 *
 */

@SuppressWarnings("unchecked")
public abstract class AbsCacheDao<T extends IEntity> extends AbsBaseDao<T> implements ICacheInitDaoOperation<T> {
	
    private final String ENTITY_INDEX_USER_ROLE_ID = "userRoleId";

    public AbsCacheDao() {
    }

    protected boolean checkIdentity(String paramString) {
        return null != paramString;
    }

    public String getAccessType() {
        return AccessType.getPublicCacheDbType();
    }

    @Override
    public T loadCacheFromDb(String id) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put(ENTITY_INDEX_USER_ROLE_ID, id);
        
        List<T> list = getRecords(param, id, AccessType.getDirectDbType());
        if ((null != list) && (list.size() > 1)) {
            throw new RuntimeException("get more than 1 records!");
        }
        if ((null != list) && (list.size() == 1)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<T> loadCachesFromDb(String id) {
    	Map<String, Object> param = new HashMap<String, Object>();
        param.put(ENTITY_INDEX_USER_ROLE_ID, id);
        
        return getRecords(param, id, AccessType.getDirectDbType());
    }

    @Override
    public T cacheLoad(Object param, String id) {
        return load(id, param, getAccessType());
    }

    @Override
    public Object cacheInsert(T t, String id) {
        return insert(t, id, getAccessType());
    }

    @Override
    public int cacheUpdate(T t, String id) {
        return update(t, id, getAccessType());
    }

    @Override
    public int cacheDelete(Object param, String id) {
        return delete(param, id, getAccessType());
    }

    @Override
    public List<T> cacheLoadAll(String id) {
        if (!checkIdentity(id)) {
            return null;
        }
        
        IDbAccessor dbAccessor = getAccessorManager().getAccessor(getAccessType());
        return (List<T>) dbAccessor.query(ENTITY_INDEX_USER_ROLE_ID, id, getEntityClass());
    }

    @Override
    public List<T> cacheLoadAll(String id, IQueryFilter queryFilter) {
        if (!checkIdentity(id)) {
            return null;
        }
        
        IDbAccessor dbAccessor = getAccessorManager().getAccessor(getAccessType());
        return (List<T>) dbAccessor.queryList(ENTITY_INDEX_USER_ROLE_ID, id, queryFilter, getEntityClass());
    }


	
}
