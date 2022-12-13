package valueannotation.beans.factory.support;

import valueannotation.beans.BeansException;
import valueannotation.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
