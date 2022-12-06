package applicationcontext.common;

import applicationcontext.beans.PropertyValue;
import applicationcontext.beans.PropertyValues;
import applicationcontext.beans.factory.config.BeanDefinition;
import applicationcontext.beans.factory.config.BeanFactoryPostProcessor;
import applicationcontext.beans.factory.ConfigurableListableBeanFactory;

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
