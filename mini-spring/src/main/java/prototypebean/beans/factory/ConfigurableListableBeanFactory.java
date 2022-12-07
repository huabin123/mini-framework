package prototypebean.beans.factory;

import prototypebean.beans.BeansException;
import prototypebean.beans.factory.config.AutowireCapableBeanFactory;
import prototypebean.beans.factory.config.BeanDefinition;
import prototypebean.beans.factory.config.BeanPostProcessor;
import prototypebean.beans.factory.config.ConfigurableBeanFactory;

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
