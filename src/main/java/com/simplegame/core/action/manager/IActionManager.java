package com.simplegame.core.action.manager;

import com.simplegame.core.action.resolver.IActionResolver;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年4月26日 下午6:32:07
 *
 */

public interface IActionManager {

	public IActionResolver getResolver(String command);
	
}
