package jdkdynamicproxy.context.event;


import jdkdynamicproxy.beans.BeansException;
import jdkdynamicproxy.beans.factory.BeanFactory;
import jdkdynamicproxy.beans.factory.BeanFactoryAware;
import jdkdynamicproxy.context.ApplicationEvent;
import jdkdynamicproxy.context.ApplicationListener;

import java.util.HashSet;
import java.util.Set;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

	public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new HashSet<>();

	private BeanFactory beanFactory;

	@Override
	public void addApplicationListener(ApplicationListener<?> listener) {
		applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
	}

	@Override
	public void removeApplicationListener(ApplicationListener<?> listener) {
		applicationListeners.remove(listener);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
