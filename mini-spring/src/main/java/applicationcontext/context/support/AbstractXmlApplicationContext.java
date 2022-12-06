package applicationcontext.context.support;

import applicationcontext.beans.BeansException;
import applicationcontext.beans.factory.support.DefaultListableBeanFactory;
import applicationcontext.beans.factory.xml.XmlBeanDefinitionReader;

import java.io.IOException;

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
