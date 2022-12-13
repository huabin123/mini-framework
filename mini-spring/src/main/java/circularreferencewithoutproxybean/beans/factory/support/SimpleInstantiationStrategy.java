package circularreferencewithoutproxybean.beans.factory.support;

import circularreferencewithoutproxybean.beans.BeansException;
import circularreferencewithoutproxybean.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author huabin
 * @DateTime 2022-11-30 13:48
 * @Desc
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    /**
     * 简单的bean实例化策略，根据bean的无参构造函数实例化对象
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor declaredConstructor = beanClass.getDeclaredConstructor();
            return declaredConstructor.newInstance();
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
