package pointcutexpression.beans.factory.config;


import pointcutexpression.beans.factory.ConfigurableListableBeanFactory;

/**
 * 允许自定义修改BeanDefinition的属性值
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有BeanDefintion加载完成后，但在bean实例化之前，提供修改BeanDefinition属性值的机制
     * @param beanFactory
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);

}
