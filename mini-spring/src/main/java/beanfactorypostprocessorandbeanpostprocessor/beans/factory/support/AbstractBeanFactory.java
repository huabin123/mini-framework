package beanfactorypostprocessorandbeanpostprocessor.beans.factory.support;

import beanfactorypostprocessorandbeanpostprocessor.beans.BeansException;
import beanfactorypostprocessorandbeanpostprocessor.beans.factory.config.BeanPostProcessor;
import beanfactorypostprocessorandbeanpostprocessor.beans.factory.config.ConfigurableBeanFactory;
import beanfactorypostprocessorandbeanpostprocessor.beans.factory.xml.BeanFactory;
import beanfactorypostprocessorandbeanpostprocessor.beans.factory.config.BeanDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huabin
 * @DateTime 2022-11-30 09:58
 * @Desc
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;


    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);

        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws Exception {
        return ((T) getBean(name));
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        //有则覆盖
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}
