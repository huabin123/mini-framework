package circularreferencewithproxybean.beans.factory.config;

import circularreferencewithproxybean.beans.factory.HierarchicalBeanFactory;
import circularreferencewithproxybean.context.util.StringValueResolver;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    /**
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例Bean
     */
    void destroySingletons();

    String resolveEmbeddedValue(String value);

    void addEmbeddedValueResolver(StringValueResolver valueResolver);
}
