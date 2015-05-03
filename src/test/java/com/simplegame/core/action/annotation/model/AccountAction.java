package com.simplegame.core.action.annotation.model;

import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年4月26日 下午6:10:03
 *
 */
@ActionWorker
public class AccountAction {

	@ActionMapping(mapping = "220")
	public void createAccount(Object message) {
		System.out.println("create account message: " + message);
	}
	
}
