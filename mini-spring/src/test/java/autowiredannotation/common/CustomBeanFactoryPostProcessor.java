package autowiredannotation.common;

import autowiredannotation.beans.PropertyValue;
import autowiredannotation.beans.PropertyValues;
import autowiredannotation.beans.factory.ConfigurableListableBeanFactory;
import autowiredannotation.beans.factory.config.BeanDefinition;
import autowiredannotation.beans.factory.config.BeanFactoryPostProcessor;

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
