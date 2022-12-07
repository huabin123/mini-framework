package prototypebean.beans.factory.support;

import prototypebean.beans.BeansException;
import prototypebean.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
