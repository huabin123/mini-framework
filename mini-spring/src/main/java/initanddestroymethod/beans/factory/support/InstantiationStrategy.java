package initanddestroymethod.beans.factory.support;

import initanddestroymethod.beans.BeansException;
import initanddestroymethod.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
