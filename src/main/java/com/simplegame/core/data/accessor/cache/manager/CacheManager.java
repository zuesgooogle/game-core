package com.simplegame.core.data.accessor.cache.manager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.simplegame.core.data.accessor.cache.IEntityCache;
import com.simplegame.core.data.accessor.cache.IEntityCacheLoader;
import com.simplegame.core.data.accessor.exception.CacheException;
import com.simplegame.core.data.accessor.write.AsyncWriteManager;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年5月21日 上午11:38:51
 * 
 */

public class CacheManager {

	private ConcurrentMap<String, IEntityCache> caches = new ConcurrentHashMap<String, IEntityCache>();

	private String name;

	private boolean needClean = false;

	private Long cleanPeriod = Long.valueOf(300000L);

	private IEntityCacheLoader entityCacheLoader;

	private AsyncWriteManager asyncWriteManager;

	public CacheManager() {

	}

	public void setCaches(ConcurrentMap<String, IEntityCache> caches) {
		this.caches = caches;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNeedClean(boolean needClean) {
		this.needClean = needClean;
	}

	public void setCleanPeriod(Long cleanPeriod) {
		this.cleanPeriod = cleanPeriod;
	}

	public void setAsyncWriteManager(AsyncWriteManager asyncWriteManager) {
		this.asyncWriteManager = asyncWriteManager;
	}

	public void setEntityCacheLoader(IEntityCacheLoader entityCacheLoader) {
		this.entityCacheLoader = entityCacheLoader;
	}

	public void activateRoleCache(String identity) {
		if (null != this.asyncWriteManager) {
			this.asyncWriteManager.syncAllDataChange(identity);
		}

		IEntityCache entityCache = null;
		if (null == entityCache) {
			entityCache = this.entityCacheLoader.loadEntityCache(identity);
			this.caches.put(identity, entityCache);
		}
		entityCache.activate();
	}

	public void freezeRoleCache(String identity) {
		this.caches.remove(identity);
		if (null != this.asyncWriteManager) {
			this.asyncWriteManager.flushDataContainer(identity);
		}
	}

	public IEntityCache getRoleCache(String identity) {
		IEntityCache entityCache = (IEntityCache) this.caches.get(identity);
		if (null == entityCache) {
			throw new CacheException("can't  matched cache to identity: " + identity);
		}
		return entityCache;
	}

}
