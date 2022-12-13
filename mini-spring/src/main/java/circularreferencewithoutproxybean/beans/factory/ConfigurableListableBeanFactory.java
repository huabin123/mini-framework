package circularreferencewithoutproxybean.beans.factory;

import circularreferencewithoutproxybean.beans.BeansException;
import circularreferencewithoutproxybean.beans.factory.config.AutowireCapableBeanFactory;
import circularreferencewithoutproxybean.beans.factory.config.BeanDefinition;
import circularreferencewithoutproxybean.beans.factory.config.BeanPostProcessor;
import circularreferencewithoutproxybean.beans.factory.config.ConfigurableBeanFactory;

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
