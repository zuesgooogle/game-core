package com.simplegame.core.event.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simplegame.core.event.IEvent;
import com.simplegame.core.event.IEventHandler;
import com.simplegame.core.event.IEventService;

/**
 *
 * @Author zeusgooogle@gmail.com
 * @sine   2015年4月23日 下午5:46:15
 *
 */
@Component
public class EventServiceImpl implements IEventService {

	@Autowired
	private EventCenter eventCenter;
	
	@Override
	public void subscribe(String type, int order, IEventHandler eventHandler) {
		eventCenter.subscribe(type, order, eventHandler);
	}

	@Override
	public void publish(IEvent event) {
		eventCenter.publish(event);
	}

}
