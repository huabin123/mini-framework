package circularreferencewithproxybean.beans.factory.support;

import circularreferencewithproxybean.beans.BeansException;
import circularreferencewithproxybean.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
