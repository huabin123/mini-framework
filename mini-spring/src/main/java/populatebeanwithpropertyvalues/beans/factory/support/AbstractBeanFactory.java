package populatebeanwithpropertyvalues.beans.factory.support;

import populatebeanwithpropertyvalues.beans.BeansException;
import populatebeanwithpropertyvalues.beans.factory.BeanFactory;
import populatebeanwithpropertyvalues.beans.factory.config.BeanDefinition;

/**
 * @Author huabin
 * @DateTime 2022-11-30 09:58
 * @Desc
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws Exception;


    @Override
    public Object getBean(String name) throws Exception {
        Object bean = getSingleton(name);

        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
