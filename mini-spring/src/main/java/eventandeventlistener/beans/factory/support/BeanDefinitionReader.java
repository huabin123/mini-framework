package eventandeventlistener.beans.factory.support;

import eventandeventlistener.beans.BeansException;
import eventandeventlistener.core.io.Resource;
import eventandeventlistener.core.io.ResourceLoader;

import java.io.IOException;

/**
 * 读取bean信息即BeanDefinition的接口
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws IOException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String[] locations) throws IOException;

}
