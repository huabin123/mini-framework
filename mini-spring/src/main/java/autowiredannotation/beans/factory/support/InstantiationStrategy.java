package autowiredannotation.beans.factory.support;

import autowiredannotation.beans.BeansException;
import autowiredannotation.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
