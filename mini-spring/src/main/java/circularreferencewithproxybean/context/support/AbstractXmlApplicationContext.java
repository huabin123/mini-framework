package circularreferencewithproxybean.context.support;

import circularreferencewithproxybean.beans.factory.support.DefaultListableBeanFactory;
import circularreferencewithproxybean.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author huabin
 * @DateTime 2022-12-05 17:06
 * @Desc
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] locations = getConfigLocations();
        if (locations != null) {
            beanDefinitionReader.loadBeanDefinitions(locations);
        }
    }

    protected abstract String[] getConfigLocations();
}
