package resourceandresourceloader.beans.factory.support;

import resourceandresourceloader.beans.BeansException;
import resourceandresourceloader.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
