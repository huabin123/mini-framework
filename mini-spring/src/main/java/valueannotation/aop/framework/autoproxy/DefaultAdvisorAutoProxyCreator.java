package valueannotation.aop.framework.autoproxy;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import valueannotation.aop.*;
import valueannotation.aop.aspectj.AspectJExpressionPointcutAdvisor;
import valueannotation.aop.framework.ProxyFactory;
import valueannotation.beans.BeansException;
import valueannotation.beans.PropertyValues;
import valueannotation.beans.factory.BeanFactory;
import valueannotation.beans.factory.BeanFactoryAware;
import valueannotation.beans.factory.config.BeanDefinition;
import valueannotation.beans.factory.config.InstantiationAwareBeanPostProcessor;
import valueannotation.beans.factory.support.DefaultListableBeanFactory;

import java.util.Collection;

/**
 * @author derekyi
 * @date 2020/12/6
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

	private DefaultListableBeanFactory beanFactory;

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		//避免死循环
		if (isInfrastructureClass(beanClass)) {
			return null;
		}

		Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
		try {
			for (AspectJExpressionPointcutAdvisor advisor : advisors) {
				ClassFilter classFilter = advisor.getPointcut().getClassFilter();
				if (classFilter.matches(beanClass)) {
					AdvisedSupport advisedSupport = new AdvisedSupport();

					BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
					Object bean = beanFactory.getInstantiationStrategy().instantiate(beanDefinition);
					TargetSource targetSource = new TargetSource(bean);
					advisedSupport.setTargetSource(targetSource);
					advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
					advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

					//返回代理对象
					return new ProxyFactory(advisedSupport).getProxy();
				}
			}
		} catch (Exception ex) {
			throw new BeansException("Error create proxy bean for: " + beanName, ex);
		}
		return null;
	}

	private boolean isInfrastructureClass(Class<?> beanClass) {
		return Advice.class.isAssignableFrom(beanClass)
				|| Pointcut.class.isAssignableFrom(beanClass)
				|| Advisor.class.isAssignableFrom(beanClass);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = (DefaultListableBeanFactory) beanFactory;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		return pvs;
	}
}
