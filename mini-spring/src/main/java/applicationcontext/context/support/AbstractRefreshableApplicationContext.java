package applicationcontext.context.support;

import applicationcontext.beans.BeansException;
import applicationcontext.beans.factory.support.DefaultListableBeanFactory;
import applicationcontext.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Author huabin
 * @DateTime 2022-12-06 08:29
 * @Desc
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() {
        return this.beanFactory;
    }

    /**
     * 创建BeanFactory，并加载BeanDefinition
     */
    @Override
    protected final void refreshBeanFactory() {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected DefaultListableBeanFactory createBeanFactory(){
        return new DefaultListableBeanFactory();
    }

    /**
     * 加载BeanDefinition
     *
     * @param beanFactory
     * @throws BeansException
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;
}
