package populatebeanwithpropertyvalues.beans.factory.support;

import populatebeanwithpropertyvalues.beans.BeansException;
import populatebeanwithpropertyvalues.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
