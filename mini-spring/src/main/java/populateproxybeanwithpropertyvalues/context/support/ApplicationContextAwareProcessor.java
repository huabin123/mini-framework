package populateproxybeanwithpropertyvalues.context.support;

import populateproxybeanwithpropertyvalues.beans.BeansException;
import populateproxybeanwithpropertyvalues.beans.factory.config.BeanPostProcessor;
import populateproxybeanwithpropertyvalues.context.ApplicationContext;
import populateproxybeanwithpropertyvalues.context.ApplicationContextAware;

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
