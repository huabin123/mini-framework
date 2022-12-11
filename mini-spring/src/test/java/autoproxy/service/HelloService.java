package autoproxy.service;

import autoproxy.beans.BeansException;
import autoproxy.beans.factory.BeanFactory;
import autoproxy.beans.factory.BeanFactoryAware;
import autoproxy.context.ApplicationContext;
import autoproxy.context.ApplicationContextAware;

/**
 * @author derekyi
 * @date 2020/11/22
 */
public class HelloService implements ApplicationContextAware, BeanFactoryAware {

	private ApplicationContext applicationContext;

	private BeanFactory beanFactory;


	public String sayHello() {
		System.out.println("hello");
		return "hello";
	}

	public ApplicationContext getApplicationContext() {
		return this.applicationContext;
	}

	public BeanFactory getBeanFactory() {
		return this.beanFactory;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
