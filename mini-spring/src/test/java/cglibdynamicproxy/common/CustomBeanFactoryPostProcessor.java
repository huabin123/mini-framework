package cglibdynamicproxy.common;

import cglibdynamicproxy.beans.PropertyValue;
import cglibdynamicproxy.beans.PropertyValues;
import cglibdynamicproxy.beans.factory.ConfigurableListableBeanFactory;
import cglibdynamicproxy.beans.factory.config.BeanDefinition;
import cglibdynamicproxy.beans.factory.config.BeanFactoryPostProcessor;

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
        personPropertyValues.addPropertyValue(new PropertyValue("name", "ivy"));
    }
}
