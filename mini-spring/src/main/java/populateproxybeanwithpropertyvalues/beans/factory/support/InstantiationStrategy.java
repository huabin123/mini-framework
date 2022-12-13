package populateproxybeanwithpropertyvalues.beans.factory.support;

import populateproxybeanwithpropertyvalues.beans.BeansException;
import populateproxybeanwithpropertyvalues.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
