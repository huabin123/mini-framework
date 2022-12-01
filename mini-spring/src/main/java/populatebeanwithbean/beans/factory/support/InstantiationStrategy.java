package populatebeanwithbean.beans.factory.support;

import populatebeanwithbean.beans.BeansException;
import populatebeanwithbean.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
