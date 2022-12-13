package circularreferencewithproxybean.aop.framework.autoproxy;

import circularreferencewithproxybean.aop.*;
import circularreferencewithproxybean.aop.aspectj.AspectJExpressionPointcutAdvisor;
import circularreferencewithproxybean.aop.framework.ProxyFactory;
import circularreferencewithproxybean.beans.BeansException;
import circularreferencewithproxybean.beans.PropertyValues;
import circularreferencewithproxybean.beans.factory.BeanFactory;
import circularreferencewithproxybean.beans.factory.BeanFactoryAware;
import circularreferencewithproxybean.beans.factory.config.InstantiationAwareBeanPostProcessor;
import circularreferencewithproxybean.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * @author derekyi
 * @date 2020/12/6
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

	private DefaultListableBeanFactory beanFactory;

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
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
		//避免死循环
		if (isInfrastructureClass(bean.getClass())) {
			return bean;
		}

		Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
		try {
			for (AspectJExpressionPointcutAdvisor advisor : advisors) {
				ClassFilter classFilter = advisor.getPointcut().getClassFilter();
				if (classFilter.matches(bean.getClass())) {
					AdvisedSupport advisedSupport = new AdvisedSupport();
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
		return bean;
	}

	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		return pvs;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		return true;
	}
}
