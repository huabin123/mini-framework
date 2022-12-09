package jdkdynamicproxy.context.support;

import jdkdynamicproxy.beans.BeansException;
import jdkdynamicproxy.beans.factory.config.BeanPostProcessor;
import jdkdynamicproxy.context.ApplicationContext;
import jdkdynamicproxy.context.ApplicationContextAware;

/**
 * @Author huabin
 * @DateTime 2022-12-07 16:54
 * @Desc
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
