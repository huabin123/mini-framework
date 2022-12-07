package initanddestroymethod.common;

import initanddestroymethod.beans.PropertyValue;
import initanddestroymethod.beans.PropertyValues;
import initanddestroymethod.beans.factory.ConfigurableListableBeanFactory;
import initanddestroymethod.beans.factory.config.BeanDefinition;
import initanddestroymethod.beans.factory.config.BeanFactoryPostProcessor;

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
