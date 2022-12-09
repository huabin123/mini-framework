package commonadvice.beans.factory.support;

import commonadvice.beans.BeansException;
import commonadvice.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
