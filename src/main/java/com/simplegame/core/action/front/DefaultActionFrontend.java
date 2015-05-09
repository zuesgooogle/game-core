package com.simplegame.core.action.front;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.simplegame.core.action.manager.IActionManager;
import com.simplegame.core.action.resolver.IActionResolver;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年5月6日 下午4:18:33
 *
 */
@Component(value="actionFrontend")
public class DefaultActionFrontend implements IActionFrontend {

	@Resource
	private IActionManager actionManager;
	
	@Override
	public void execute(String command, Object message) {
		IActionResolver resolver = actionManager.getResolver(command);
		
		if(null != resolver){
			resolver.execute(message);
		}else{
			throw new NullPointerException("action worker [" + command + "] is not existed.");
		}
	}

}
