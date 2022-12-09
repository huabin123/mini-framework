package jdkdynamicproxy.beans.factory.support;

import jdkdynamicproxy.beans.BeansException;
import jdkdynamicproxy.core.io.Resource;
import jdkdynamicproxy.core.io.ResourceLoader;

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
