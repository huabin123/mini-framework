package beanfactorypostprocessorandbeanpostprocessor.beans.factory.config;

import beanfactorypostprocessorandbeanpostprocessor.beans.factory.xml.HierarchicalBeanFactory;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    /**
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
