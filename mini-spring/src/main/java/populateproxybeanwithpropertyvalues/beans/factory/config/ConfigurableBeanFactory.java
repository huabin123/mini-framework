package populateproxybeanwithpropertyvalues.beans.factory.config;

import populateproxybeanwithpropertyvalues.beans.factory.HierarchicalBeanFactory;
import populateproxybeanwithpropertyvalues.context.util.StringValueResolver;

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
