package beanfactorypostprocessorandbeanpostprocessor.beans.factory.support;

import xmlfiledefinebean.core.io.Resource;
import xmlfiledefinebean.core.io.ResourceLoader;

import java.io.IOException;

/**
 * 读取bean信息即BeanDefinition的接口
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws IOException;

    void loadBeanDefinitions(String location) throws IOException;

    void loadBeanDefinitions(String[] locations) throws IOException;

}
