package beanfactorypostprocessorandbeanpostprocessor.beans.factory.support;

import beanfactorypostprocessorandbeanpostprocessor.beans.BeansException;
import beanfactorypostprocessorandbeanpostprocessor.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
