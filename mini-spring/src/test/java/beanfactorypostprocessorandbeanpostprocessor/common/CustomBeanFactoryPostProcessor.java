package beanfactorypostprocessorandbeanpostprocessor.common;

import beanfactorypostprocessorandbeanpostprocessor.beans.PropertyValue;
import beanfactorypostprocessorandbeanpostprocessor.beans.PropertyValues;
import beanfactorypostprocessorandbeanpostprocessor.beans.factory.config.BeanDefinition;
import beanfactorypostprocessorandbeanpostprocessor.beans.factory.config.BeanFactoryPostProcessor;
import beanfactorypostprocessorandbeanpostprocessor.beans.factory.xml.ConfigurableListableBeanFactory;

/**
 * @Author huabin
 * @DateTime 2022-12-02 15:38
 * @Desc
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        BeanDefinition personBeanDefinition = beanFactory.getBeanDefinition("person");
        PropertyValues personPropertyValues = personBeanDefinition.getPropertyValues();

        // 将person的name修改为ice
        personPropertyValues.addPropertyValue(new PropertyValue("name", "ice"));
    }
}
