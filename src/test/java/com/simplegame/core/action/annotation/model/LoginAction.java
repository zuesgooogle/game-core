package com.simplegame.core.action.annotation.model;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年4月26日 下午6:07:55
 *
 */
@ActionWorker
public class LoginAction {

	@ActionMapping(mapping = "110")
	public void login(Object message) {
		System.out.println("login message: " + message);
	}
	
}
