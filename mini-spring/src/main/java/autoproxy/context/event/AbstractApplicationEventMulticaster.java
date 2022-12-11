package autoproxy.context.event;


import autoproxy.beans.BeansException;
import autoproxy.beans.factory.BeanFactory;
import autoproxy.beans.factory.BeanFactoryAware;
import autoproxy.context.ApplicationEvent;
import autoproxy.context.ApplicationListener;

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
