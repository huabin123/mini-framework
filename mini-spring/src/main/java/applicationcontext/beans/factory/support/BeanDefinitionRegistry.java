package applicationcontext.beans.factory.support;

import applicationcontext.beans.factory.config.BeanDefinition;


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

    /**
     * 是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containBeanDefinition(String beanName);

}
