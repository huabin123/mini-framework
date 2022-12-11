package pointcutadvisor.common;

import pointcutadvisor.beans.PropertyValue;
import pointcutadvisor.beans.PropertyValues;
import pointcutadvisor.beans.factory.ConfigurableListableBeanFactory;
import pointcutadvisor.beans.factory.config.BeanDefinition;
import pointcutadvisor.beans.factory.config.BeanFactoryPostProcessor;

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
