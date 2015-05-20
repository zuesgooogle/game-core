package com.simplegame.core.data;

import java.io.Serializable;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月20日 下午6:16:16
 *
 */

public interface IEntity extends Serializable {

	public String getPirmaryKey();

    public Object getPrimaryKey();

    /**
     * async save entity to database need copy
     * 
     * @return
     */
    public IEntity copy();
	
}
