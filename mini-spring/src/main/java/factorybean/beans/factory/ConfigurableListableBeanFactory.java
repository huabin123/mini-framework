package factorybean.beans.factory;

import factorybean.beans.BeansException;
import factorybean.beans.factory.config.AutowireCapableBeanFactory;
import factorybean.beans.factory.config.BeanDefinition;
import factorybean.beans.factory.config.BeanPostProcessor;
import factorybean.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * 根据名称查找BeanDefinition
     * @param beanName
     * @return
     */
    BeanDefinition getBeanDefinition(String beanName);

    /**
     * 提前实例化所有单例实例
     *
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
