package proxyfactory.beans.factory.support;

import proxyfactory.beans.BeansException;
import proxyfactory.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
