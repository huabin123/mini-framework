package xmlfiledefinebean.beans.factory.support;

import xmlfiledefinebean.beans.BeansException;
import xmlfiledefinebean.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
