package com.simplegame.core.data.accessor;

import java.util.List;

import com.simplegame.core.data.IEntity;
import com.simplegame.core.data.IQueryFilter;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月20日 下午6:26:43
 *
 */

public interface IDbAccessor {

    public Object insert(String key, IEntity entity, Class<? extends IEntity> clazz);
    
    public IEntity query(String key, Object entity, Class<? extends IEntity> clazz);
    
    public List<IEntity> query(String key, String name, Object value, Class<? extends IEntity> clazz);
    
    public List<IEntity> query(String key, String name, Object value, IQueryFilter queryFilter, Class<? extends IEntity> clazz);
    
    public int delete(String key, Object entity, Class<? extends IEntity> clazz);
    
    public int update(String key, IEntity entity );


	
}
