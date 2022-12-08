package pointcutexpression.beans.factory.support;

import pointcutexpression.beans.BeansException;
import pointcutexpression.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
