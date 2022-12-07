package initanddestroymethod.beans.factory;

import initanddestroymethod.beans.BeansException;
import initanddestroymethod.beans.factory.config.AutowireCapableBeanFactory;
import initanddestroymethod.beans.factory.config.BeanDefinition;
import initanddestroymethod.beans.factory.config.BeanPostProcessor;
import initanddestroymethod.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory  extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

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
