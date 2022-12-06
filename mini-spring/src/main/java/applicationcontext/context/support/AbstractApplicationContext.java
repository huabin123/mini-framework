package applicationcontext.context.support;

import applicationcontext.beans.factory.config.BeanFactoryPostProcessor;
import applicationcontext.beans.factory.config.BeanPostProcessor;
import applicationcontext.beans.factory.ConfigurableListableBeanFactory;
import applicationcontext.context.ConfigurableApplicationContext;
import applicationcontext.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @Author huabin
 * @DateTime 2022-12-06 08:29
 * @Desc
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() {
        // 创建BeanFactory，并加载BeanDefinition
        refreshBeanFactory();
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 在bean实例化之前，执行BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessor(beanFactory);

        // BeanPostProcessor需要需要提前在其他bean实例化之前注册
        registerBeanPostProcessors(beanFactory);

        // 提前实例化单例bean
        beanFactory.preInstantiateSingletons();
    }

    /**
     * 注册BeanPostProcessor
     * @param beanFactory
     */
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws Exception {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public Object getBean(String name) throws Exception {
        return getBeanFactory().getBean(name);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    public abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 创建BeanFactory，并加载BeanDefinition
     */
    protected abstract void refreshBeanFactory();

    protected void invokeBeanFactoryPostProcessor(ConfigurableListableBeanFactory beanFactory){

        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);

        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }

    }
}
