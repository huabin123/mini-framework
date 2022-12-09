package jdkdynamicproxy.beans.factory;

import jdkdynamicproxy.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
