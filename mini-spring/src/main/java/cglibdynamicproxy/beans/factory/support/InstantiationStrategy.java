package cglibdynamicproxy.beans.factory.support;

import cglibdynamicproxy.beans.BeansException;
import cglibdynamicproxy.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
