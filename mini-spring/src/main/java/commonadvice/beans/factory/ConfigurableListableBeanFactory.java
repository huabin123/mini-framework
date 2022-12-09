package commonadvice.beans.factory;

import commonadvice.beans.BeansException;
import commonadvice.beans.factory.config.AutowireCapableBeanFactory;
import commonadvice.beans.factory.config.BeanDefinition;
import commonadvice.beans.factory.config.BeanPostProcessor;
import commonadvice.beans.factory.config.ConfigurableBeanFactory;

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
