package circularreferencewithproxybean.context.support;

import circularreferencewithproxybean.beans.BeansException;
import circularreferencewithproxybean.beans.factory.config.BeanPostProcessor;
import circularreferencewithproxybean.context.ApplicationContext;
import circularreferencewithproxybean.context.ApplicationContextAware;

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
