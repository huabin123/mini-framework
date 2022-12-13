package circularreferencewithoutproxybean.beans.factory.support;

import circularreferencewithoutproxybean.beans.BeansException;
import circularreferencewithoutproxybean.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
