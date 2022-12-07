package awareinterface.beans.factory.support;

import awareinterface.beans.BeansException;
import awareinterface.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
