package eventandeventlistener.beans.factory.support;

import eventandeventlistener.beans.BeansException;
import eventandeventlistener.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
