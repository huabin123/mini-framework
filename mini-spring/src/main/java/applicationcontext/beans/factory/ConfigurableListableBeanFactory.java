package applicationcontext.beans.factory;

import applicationcontext.beans.BeansException;
import applicationcontext.beans.factory.config.AutowireCapableBeanFactory;
import applicationcontext.beans.factory.config.BeanDefinition;
import applicationcontext.beans.factory.config.BeanPostProcessor;
import applicationcontext.beans.factory.config.ConfigurableBeanFactory;

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
