package xmlfiledefinebean.beans.factory.support;

import xmlfiledefinebean.core.io.DefaultResourceLoader;
import xmlfiledefinebean.core.io.Resource;
import xmlfiledefinebean.core.io.ResourceLoader;

import java.io.IOException;

/**
 * @Author huabin
 * @DateTime 2022-12-02 07:43
 * @Desc
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public void loadBeanDefinitions(String[] locations) throws IOException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }
}
