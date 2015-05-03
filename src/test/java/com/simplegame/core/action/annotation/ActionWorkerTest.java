package com.simplegame.core.action.annotation;

import org.junit.Test;

import com.simplegame.core.action.manager.DefaultActionManager;
import com.simplegame.core.action.resolver.IActionResolver;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年4月26日 下午6:07:04
 *
 */

public class ActionWorkerTest extends BasicTest {

	@Test
	public void load() {
		
		DefaultActionManager manager = ctx.getBean(DefaultActionManager.class);
		
		IActionResolver resolver = manager.getResolver("110");
	
		resolver.execute("test");
	}

}
