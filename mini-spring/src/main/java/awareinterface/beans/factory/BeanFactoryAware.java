package awareinterface.beans.factory;

import awareinterface.beans.factory.support.AbstractAutowireCapableBeanFactory;

/**
 * 实现该接口，能感知所属BeanFactory
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory);
}
