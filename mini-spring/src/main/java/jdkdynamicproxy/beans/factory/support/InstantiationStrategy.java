package jdkdynamicproxy.beans.factory.support;

import jdkdynamicproxy.beans.BeansException;
import jdkdynamicproxy.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
