package instantiationstrategy.beans.factory.support;

import instantiationstrategy.beans.BeansException;
import instantiationstrategy.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
