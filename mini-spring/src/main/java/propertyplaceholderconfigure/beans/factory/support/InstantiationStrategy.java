package propertyplaceholderconfigure.beans.factory.support;

import propertyplaceholderconfigure.beans.BeansException;
import propertyplaceholderconfigure.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
