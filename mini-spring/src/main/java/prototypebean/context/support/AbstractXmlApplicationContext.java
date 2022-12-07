package prototypebean.context.support;

import prototypebean.beans.factory.support.DefaultListableBeanFactory;
import prototypebean.beans.factory.xml.XmlBeanDefinitionReader;

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