package populatebeanwithpropertyvalues.beans.factory.support;

import populatebeanwithpropertyvalues.beans.factory.config.BeanDefinition;


/**
 * BeanDefinition注册表接口
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
