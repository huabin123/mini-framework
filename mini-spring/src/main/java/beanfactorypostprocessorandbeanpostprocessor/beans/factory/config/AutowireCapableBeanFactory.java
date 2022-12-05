package beanfactorypostprocessorandbeanpostprocessor.beans.factory.config;


import beanfactorypostprocessorandbeanpostprocessor.beans.BeansException;
import beanfactorypostprocessorandbeanpostprocessor.beans.factory.xml.BeanFactory;

/**
 * 【新增】
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行BeanPostProcessors的postProcessBeforeInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
            throws BeansException;


    /**
     * 执行BeanPostProcessors的postProcessAfterInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws BeansException;

}
