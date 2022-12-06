package applicationcontext.beans.factory.support;

import applicationcontext.beans.BeansException;
import applicationcontext.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
