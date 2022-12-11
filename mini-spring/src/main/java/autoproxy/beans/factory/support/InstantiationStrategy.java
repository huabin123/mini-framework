package autoproxy.beans.factory.support;

import autoproxy.beans.BeansException;
import autoproxy.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
