package cglibdynamicproxy.beans.factory;

import cglibdynamicproxy.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
