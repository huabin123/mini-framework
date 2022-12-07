package awareinterface.beans.factory;

import awareinterface.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
