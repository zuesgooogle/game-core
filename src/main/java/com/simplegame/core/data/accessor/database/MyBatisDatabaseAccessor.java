package com.simplegame.core.data.accessor.database;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.simplegame.core.data.IEntity;
import com.simplegame.core.data.IQueryFilter;
import com.simplegame.core.data.accessor.IDbAccessor;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月20日 下午6:46:12
 * 
 */

public class MyBatisDatabaseAccessor implements IDbAccessor {

	private SqlSessionTemplate template;

	@Override
	public Object insert(String key, IEntity entity, Class<? extends IEntity> clazz) {
		template.insert(StatementUtils.getStatement(StatementUtils.INSERT_OP, entity), entity);
		return entity;
	}

	@Override
	public IEntity query(String key, Object entity, Class<? extends IEntity> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntity> query(String key, String name, Object value, Class<? extends IEntity> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntity> query(String key, String name, Object value, IQueryFilter queryFilter, Class<? extends IEntity> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String key, Object entity, Class<? extends IEntity> clazz) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String key, IEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

}
