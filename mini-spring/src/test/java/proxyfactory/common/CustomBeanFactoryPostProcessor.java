package proxyfactory.common;

import proxyfactory.beans.PropertyValue;
import proxyfactory.beans.PropertyValues;
import proxyfactory.beans.factory.ConfigurableListableBeanFactory;
import proxyfactory.beans.factory.config.BeanDefinition;
import proxyfactory.beans.factory.config.BeanFactoryPostProcessor;

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
