package factorybean.beans.factory.support;

import factorybean.beans.BeansException;
import factorybean.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
