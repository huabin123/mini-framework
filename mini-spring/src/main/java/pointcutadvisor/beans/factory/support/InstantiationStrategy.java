package pointcutadvisor.beans.factory.support;

import pointcutadvisor.beans.BeansException;
import pointcutadvisor.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
