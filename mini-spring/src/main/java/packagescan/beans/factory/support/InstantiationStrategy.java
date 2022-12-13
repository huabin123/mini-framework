package packagescan.beans.factory.support;

import packagescan.beans.BeansException;
import packagescan.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
