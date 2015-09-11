package com.simplegame.core.action.manager;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import com.simplegame.core.SpringApplicationContext;
import com.simplegame.core.action.annotation.ActionMapping;
import com.simplegame.core.action.annotation.ActionWorker;
import com.simplegame.core.action.resolver.DefaultActionResolver;
import com.simplegame.core.action.resolver.IActionResolver;

/**
 * 
 * @Author zeusgooogle@gmail.com
 * @sine 2015年4月26日 下午6:33:00
 * 
 */
@Component
public class DefaultActionManager implements IActionManager {

	private final static Logger LOG = LoggerFactory.getLogger(DefaultActionResolver.class);

	private Map<String, IActionResolver> resolvers = new HashMap<String, IActionResolver>();

	private ApplicationContext ctx;
	
	@PostConstruct
	public void init() {
		ctx = SpringApplicationContext.getApplicationContext();

		Map<String, Object> workers = ctx.getBeansWithAnnotation(ActionWorker.class);
		for (Object clazz : workers.values()) {
			analyzeClass( clazz.getClass() );
		}
	}

	private void analyzeClass(Class<?> clazz) {
		ActionWorker actionWorker = AnnotationUtils.findAnnotation(clazz, ActionWorker.class);
		if (null != actionWorker) {
			try {
				
				Method[] methods = clazz.getDeclaredMethods();

				for (Method m : methods) {
					ActionMapping commandMapping = AnnotationUtils.findAnnotation(m, ActionMapping.class);
					if (null != commandMapping) {
						resolvers.put(commandMapping.mapping(), new DefaultActionResolver(m, ctx.getBean(clazz)));
					}
				}
			} catch (Exception e) {
				LOG.error("analye class error: ", e);
				throw new RuntimeException("error in analyzeClass", e);
			}
		}

	}

	@Override
	public IActionResolver getResolver(String command) {
		return resolvers.get(command);
	}


}
